package com.server.exception;

public class MethodArgumentNotValidException extends RuntimeException{
    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
