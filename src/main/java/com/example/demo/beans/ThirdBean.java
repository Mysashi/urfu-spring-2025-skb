package com.example.demo.beans;


import com.example.demo.annotation.CheckDefaultAnnotation;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(CheckDefaultAnnotation.class)
@Component
public class ThirdBean {
    private static final Logger logger = LoggerFactory.getLogger(ThirdBean.class);
    @PostConstruct
    void init() {
        logger.info("ConditionalCheckDefaultBean was initialized");
    }
}
