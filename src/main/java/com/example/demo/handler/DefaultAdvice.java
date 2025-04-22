package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class DefaultAdvice {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleException(Exception e) {
        String errorMessage = e.getMessage();
        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = "An unexpected error occurred."; // Provide a default message
        }

        return Map.of(
                "status", "502",
                "error", "Bad Gateway",
                "message", errorMessage
        );
    }
}
