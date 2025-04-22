package com.example.demo;


import com.example.demo.foodBeans.ApplePie;
import com.example.demo.foodBeans.Pizza;

// Конфигурация позволяет вписывать бины в конфигурацию вручную, закоменчен потому что использую автоматическое создание бинов
//@Configuration
public class FoodConfiguration {

//    @Bean
    public Pizza cookPizza() {
        return new Pizza();
    }

//    @Bean
    public ApplePie cookApplePie() {
        return new ApplePie();
    }

}
