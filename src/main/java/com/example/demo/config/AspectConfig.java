package com.example.demo.config;

import com.example.demo.exception.ApiLimitExceedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


@Aspect
@Component
public class AspectConfig {

    private static final Logger log = LoggerFactory.getLogger(Class.class);
    @Value("${aspect.max.calls}")
    private int calls;

    private int currentCalls = 1;


    @Pointcut("execution(* com.example.demo.controller.ApiController.sendApi())")
    public void callApi() {
    }

    @After("callApi()")
    public void incrementCounter() {
        if (currentCalls > calls) {
            log.error("Ошибка! Превышение количества допустимых вызова метода sendApi! " + "Текущее кол-во вызовов: " + currentCalls + " Максимально-допустимое " + calls);
            throw new ApiLimitExceedException("Превышено количество вызовов!");
        }
        else {
            log.warn("Текущее кол-во вызовов метода sendApi: " + currentCalls + " Максимально-допустимое " + calls);
        }
        currentCalls++;
    }





}
