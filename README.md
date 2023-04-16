# Autosar Container Sorter

This is a Java program that sorts Autosar containers based on their short names. The program takes an input file, which contains one or more Autosar containers, and outputs a sorted version of the file. It runs it on three input files: `1.standard_input.arxml`, `2.wrong_extension.xml`, and `3.empty_file.arxml`. The batch file is intended to demonstrate how to use the `javac` command to compile Java files and how to run a Java program from the command line.

## Getting Started

To run the program, you will need to have Java installed on your machine. You can download Java from the [official Java website](https://www.java.com/en/download/).

Once Java is installed, you can compile the program by running the batch file:
`run_me.bat`

To use the batch file, follow these steps:

1. Open a command prompt or terminal window.
2. Navigate to the directory where the batch file is located.
3. Type the following command:

   `````
   compile_and_run.bat
   ```

4. Press Enter to run the batch file.

The batch file will compile the Java files for the Autosar Container Sorter program using the `javac *.java` command, which will compile all the Java files in the current directory. It will then run the program on the three input files using the `java AutosarContainerSorter` command.

Files Tested:

1. `1.standard_input.arxml`: An example input file that contains standard Autosar container data.

2. `2.wrong_extension.xml`: An example input file that has the wrong file extension.

3. `3.empty_file.arxml`: An example input file that is empty.


## Code Overview

The code is split into five segments:

1. `Constants`: This is an interface that contains various string constants used in the program.

2. `Container`: This class represents an Autosar container. It implements the `Comparable` interface to allow for sorting based on short names.

3. `EmptyAutosarFileException`: This is a custom exception class that handles cases where an input file is empty or contains no valid data.

4. `NotValidAutosarFileException`: This is a custom exception class that handles cases where an input file has an invalid extension or is otherwise not a valid Autosar file.

5. `AutosarContainerSorter`: The main Java file for the Autosar Container Sorter program. This file contains the main method and is responsible for parsing the input file, sorting the containers, and writing the sorted containers to the output file.
