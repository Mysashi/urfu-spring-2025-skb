package com.example.demo.foodBeans;

import com.example.demo.Cookable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ApplePie implements Cookable {


    // Инициализация бина
    @PostConstruct
    public void initialize() {
        System.out.println("LOGGER: ApplePie bean was succesfully initialized!");
    }

    // Удаление бина
    @PreDestroy
    public void destroyBean() {
        System.out.println("LOGGER: ApplePie bean was destroyed :(" );
    }


    @Override
    public String nameCookable() {
        return "Apple pie";
    }

    @Override
    public String[] cook() {
        return new String[] {"Apple", "Yeast", "Eggs", "Apples", "Sugar", "Milk", "butter"};
    }



    @Override
    public String describe() {
        return "Make the apple pie filling. Preheat the oven to 375°F.Roll out the dough and line the pie plate" +
                "Add the apple filling. Roll out the top crust, place over apples, trim and crimp edges" +
                "and etc...";
    }

    @Override
    public int estimateInRubles() {
        return 300;
    }
}
