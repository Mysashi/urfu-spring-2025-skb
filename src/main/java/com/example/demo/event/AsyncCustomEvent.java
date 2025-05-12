package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class AsyncCustomEvent extends ApplicationEvent {
    private final String message;


    public AsyncCustomEvent(String message, Object source) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
