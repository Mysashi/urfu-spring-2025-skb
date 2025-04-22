package com.example.demo.annotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CheckDefaultAnnotation implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        String envValue = env.getProperty("default-variable");
        System.out.println("ENVVALUE " + envValue);
        if (envValue != null) {
            return !envValue.equals("default");
        }
        return false;
    }
}
