package com.example.demo.task_07;


import com.example.demo.task_07.model.Event;
import com.example.demo.task_07.repository.EventsRepository;
import com.example.demo.task_07.service.EventsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsController {

    @Autowired
    public EventsService eventsService;

    @Autowired
    public EventsRepository repository;


    @RequestMapping(
            value = "setEvents",
            method = RequestMethod.POST)
    public ResponseEntity<String> setEvents(@RequestBody String eventRequest, Model model) {
        Event event = eventsService.parseJson(eventRequest);
        return new ResponseEntity<>("Event sent succesfully!", HttpStatus.OK);

    }

    @GetMapping("/getEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> allEvents = repository.findAll();

        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }

}
