package com.example.demo.initialize;

import com.example.demo.publisher.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    final CustomEventPublisher customEventPublisher;

    @Autowired
    public EventService(CustomEventPublisher customEventPublisher) {
        this.customEventPublisher = customEventPublisher;
    }

    public void publishAsyncEvent() {
        customEventPublisher.publishAsyncEvent("Async" + "\n");
    }

    public void publishCommonEvent() {
        customEventPublisher.publishCustomEvent("Common" + "\n");
    }

    public void publishTransactionlEvent() {
        customEventPublisher.publishTransactionalEvent("Transactional" + "\n");
    }



}
