
// Import necessary Java libraries
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Define the Container class, which implements the Comparable interface
class Container implements Comparable<Container> {

    // Private instance variables
    private Node node;
    private String shortName = "";

    // Constructor method
    Container(Node node) {
        // Initialize instance variables
        this.node = node;
        NodeList containerChildren = node.getChildNodes();
        for (int i = 0; i < containerChildren.getLength(); i++) {
            if (containerChildren.item(i).getNodeName() == Constants.SHORTNAME) {
                shortName = containerChildren.item(i).getTextContent();
            }
        }
    }

    /**
     * Get the node associated with this container.
     *
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    // Implement the compareTo method from the Comparable interface
    @Override
    public int compareTo(Container o) {
        return shortName.compareTo(o.shortName);
    }

    // Override the toString method to return a trimmed version of the node's text content
    @Override
    public String toString() {
        return node.getTextContent().trim();
    }
}