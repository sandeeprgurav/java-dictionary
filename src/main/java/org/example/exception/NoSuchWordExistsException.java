package org.example.exception;

public class NoSuchWordExistsException extends Exception {
    public NoSuchWordExistsException(String errorMessage) {
        super(errorMessage);
    }
}
