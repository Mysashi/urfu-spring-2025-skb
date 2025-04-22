package com.example.demo;


import com.example.demo.classesForInjections.Shop;
import org.springframework.stereotype.Component;

@Component
public class Test {

    public Test(Shop shop) {
        System.out.println("TEST0: " + shop.getManufactury().name()); // Тестирование реализации setter injection
        System.out.println("TEST1: " + shop.getCookableArrayList()); // Тестирование реализации constructor injection
        System.out.println("TEST2: " + shop.getManufactury().nameReceipts()); // Тестирование реализации field injection
        System.out.println("TEST3: " + shop); // Внедрение в метод toString() двух методов describe разных классов(Pizza, ApplePie), реализующих Cookable

    }
}
