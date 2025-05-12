package com.example.demo.handler;


import com.example.demo.exception.ApiLimitExceedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiLimitHandler {

    @ExceptionHandler(ApiLimitExceedException.class)
    public ResponseEntity<String> handlerApiException(ApiLimitExceedException e) {
        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .body(e.getMessage());
    }
}
