package com.example.demo.beans;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class TestBean {

    private static final Logger logger = LoggerFactory.getLogger(TestBean.class);

    @PostConstruct
    void initialize() {
        logger.info("TESTBEAN INITIALIZED. Test-profile is activated");
    }
}
