# Autosar Container Sorter

This is a Java program that sorts Autosar containers based on their short names. The program takes an input file, which contains one or more Autosar containers, and outputs a sorted version of the file.

## Getting Started

To run the program, you will need to have Java installed on your machine. You can download Java from the [official Java website](https://www.java.com/en/download/).

Once Java is installed, you can compile the program by running the batch file:
`run_me.bat`



## Code Overview

The code is split into five segments:

1. `Constants`: This is an interface that contains various string constants used in the program.

2. `Container`: This class represents an Autosar container. It implements the `Comparable` interface to allow for sorting based on short names.

3. `EmptyAutosarFileException`: This is a custom exception class that handles cases where an input file is empty or contains no valid data.

4. `NotValidAutosarFileException`: This is a custom exception class that handles cases where an input file has an invalid extension or is otherwise not a valid Autosar file.

5. `AutosarContainerSorter`: The main Java file for the Autosar Container Sorter program. This file contains the main method and is responsible for parsing the input file, sorting the containers, and writing the sorted containers to the output file.
