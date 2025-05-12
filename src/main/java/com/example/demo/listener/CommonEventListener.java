package com.example.demo.listener;

import com.example.demo.event.AsyncCustomEvent;
import com.example.demo.event.CustomEvent;
import com.example.demo.event.TransactionalEvent;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;


@Service
public class CommonEventListener {

    private static final Logger logger = LoggerFactory.getLogger(CommonEventListener.class);


    @EventListener
    public void handleCommonEvent(CustomEvent event) {
      logger.info("CustomEvent handled!" + event.getMessage());
    }

    @SneakyThrows
    @EventListener
    @Async
    public void handleAsyncEvent(AsyncCustomEvent event) {
        try {
            Thread.sleep(1000);
            logger.info("AsyncEvent handled!" + event.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @EventListener
    @SneakyThrows
    @TransactionalEventListener
    public void handleTransactionalEvent(TransactionalEvent event) {
        if (event.isIncluded()) {
            logger.info("TransactionalEvent included: " + event.getMessage());
        }
        else {
            logger.info("TranscationalEvent WAS Not included");
        }
    }

}
