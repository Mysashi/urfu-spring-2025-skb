package com.example.demo;

import com.example.demo.initialize.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    final EventService eventService;

    @Autowired
    public EventController( EventService eventService) {

        this.eventService = eventService;
    }

    @GetMapping("/async")
    public void getAsyncEvent() {
        eventService.publishAsyncEvent();
    }

    @GetMapping("/common")
    public void getCommonEvent() {
        eventService.publishCommonEvent();
    }

    @GetMapping("/transactional")
    public void getTreansactionalEvent() {
        eventService.publishTransactionlEvent();
    }

}
