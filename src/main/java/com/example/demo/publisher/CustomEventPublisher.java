package com.example.demo.publisher;

import com.example.demo.event.AsyncCustomEvent;
import com.example.demo.event.CustomEvent;
import com.example.demo.event.TransactionalEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomEventPublisher {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    private static final Logger logger = LoggerFactory.getLogger(CustomEventPublisher.class);


    public void publishCustomEvent(final String message) {
        logger.info("Publishing common event message");
        CustomEvent customEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customEvent);
    }

    public void publishAsyncEvent(final String message) {
        logger.info("Publishing async event message");
        AsyncCustomEvent asyncEvent = new AsyncCustomEvent(message, this);
        applicationEventPublisher.publishEvent(asyncEvent);
    }

    public void publishTransactionalEvent(final String message) {
        logger.info("Publishing transactional event message");
        TransactionalEvent transactionalEventIncluded = new TransactionalEvent(true, message, this);
        TransactionalEvent  transactionalEventNotIncluded = new TransactionalEvent(false, message, this);
        applicationEventPublisher.publishEvent(transactionalEventIncluded);
        applicationEventPublisher.publishEvent(transactionalEventNotIncluded);
    }

}
