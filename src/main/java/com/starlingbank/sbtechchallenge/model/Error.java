package com.starlingbank.sbtechchallenge.model;

public class Error {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                '}';
    }

    public Error(String message) {
        this.message = message;
    }

    public Error() {
    }
}

