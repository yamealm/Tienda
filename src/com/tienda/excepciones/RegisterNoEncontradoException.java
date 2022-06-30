package com.tienda.excepciones;

public class RegisterNoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public RegisterNoEncontradoException(String message) {
        super(message);
    }

    public RegisterNoEncontradoException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
