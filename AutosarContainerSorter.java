
// Import necessary Java libraries
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

// Define the main class
public class AutosarContainerSorter {
    public static void main(String[] args) {

        // Get the file path argument from the command line
        String filePath = args[0].trim();
        try {
            // Create a new DocumentBuilder and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Check if the file has the correct extension
            if (!filePath.endsWith(Constants.EXTENSION)) {
                throw new NotVaildAutosarFileException(filePath + " is not a valid ARXML File. Please try again.");
            }

            Document doc = builder.parse(filePath);
            NodeList autosarChildren = doc.getFirstChild().getChildNodes();
            List<Container> containersList = new ArrayList<Container>();

            // Loop through each element in the NodeList and add containers to the list
            for (int i = 0; i < autosarChildren.getLength(); i++) {
                if (autosarChildren.item(i).getNodeName() == Constants.CONTAINER) {
                    containersList.add(new Container(autosarChildren.item(i)));
                }
            }

            // Sort the containers in the list
            containersList.sort(null);

            // Create a new Document and add the sorted containers to it
            Document newDoc = builder.newDocument();
            newDoc.setXmlStandalone(true);

            Element el = newDoc.createElement(Constants.AUTOSAR);
            for (Container container : containersList) {
                el.appendChild(newDoc.importNode(container.getNode(), true));
            }

            newDoc.appendChild(el);

            // Create a new Transformer and write the modified XML to a new file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(newDoc);
            StreamResult result = new StreamResult(
                    new File(filePath.replace(Constants.EXTENSION, "_mod" + Constants.EXTENSION)));
            transformer.transform(source, result);
            System.out.println("File Output Successfully");
        } catch (SAXParseException e) {
            // Handle exceptions for invalid XML files (Empty files)
            throw new EmptyAutosarFileException(filePath + " is an empty File. Please try again.");

        } catch (Exception e) {
            // Handle other exceptions by printing the stack trace
            e.printStackTrace();
        }
    }
}
