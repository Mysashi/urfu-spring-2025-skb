package com.example.demo.exception;

public class ApiLimitExceedException extends RuntimeException {
    public ApiLimitExceedException(String message) {
        super(message);
    }


}
