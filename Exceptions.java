// Custom Checked exception class for handling invalid Autosar files
class NotVaildAutosarFileException extends Exception {
    NotVaildAutosarFileException(String s) {
        super(s);
    }
}

// Custom Unchecked exception class for handling empty Autosar files
class EmptyAutosarFileException extends RuntimeException {
    EmptyAutosarFileException(String s) {
        super(s);
    }
}