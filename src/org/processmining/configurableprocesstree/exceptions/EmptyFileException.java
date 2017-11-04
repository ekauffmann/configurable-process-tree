package org.processmining.configurableprocesstree.exceptions;

import java.util.EmptyStackException;

public class EmptyFileException extends Exception {
    private String filename;

    public EmptyFileException(String filename) {
        super("File '" + filename + "' is empty");
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }


}
