package com.example.demo.beans;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

// Зависит от TestBean
@ConditionalOnBean(TestBean.class)
@Component
public class AnotherBean {

    private static final Logger logger = LoggerFactory.getLogger(AnotherBean.class);
    @PostConstruct
    void init() {
        logger.info("Bean,which relies on profile test was initialized");
    }

}
