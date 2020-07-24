package org.example.exception;

public class NotAValidWordException extends Exception {
    public NotAValidWordException(String errorMessage) {
        super(errorMessage);
    }
}
