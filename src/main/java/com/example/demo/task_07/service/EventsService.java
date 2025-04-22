package com.example.demo.task_07.service;

import com.example.demo.task_07.model.Event;
import com.example.demo.task_07.repository.EventsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EventsService {


    private EventsRepository repository;

    @Autowired
    public EventsService(EventsRepository repository) {
        this.repository = repository;

    }

    private ObjectMapper objectMapper = new ObjectMapper();


    public Event parseJson(String jsonString) {
        try {
            Event event =  objectMapper.readValue(jsonString, Event.class);
            return repository.save(event);

        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
