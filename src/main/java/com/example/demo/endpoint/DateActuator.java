package com.example.demo.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id="date-actuator")
public class DateActuator {
   Logger logger = LoggerFactory.getLogger(DateActuator.class);

    @ReadOperation
    public String getDate() {
        String localDate = LocalDateTime.now().toString();
        logger.info("Актуатор времени: " + localDate);
        return localDate;
    }
}
