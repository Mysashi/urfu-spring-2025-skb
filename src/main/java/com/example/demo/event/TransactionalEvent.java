package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class TransactionalEvent extends ApplicationEvent {

    boolean included;

    String message;


    public TransactionalEvent(boolean included, String message, Object source) {
        super(source);
        this.included = included;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isIncluded() {
        return included;
    }


}
