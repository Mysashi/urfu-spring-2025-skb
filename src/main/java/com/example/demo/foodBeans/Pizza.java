package com.example.demo.foodBeans;

import com.example.demo.Cookable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class Pizza implements Cookable {

    // Тестирование создания бина
    @PostConstruct
    public void initialize() {
        System.out.println("LOGGER: Pizza bean was succesfully initialized!");
    }


    // Тестирование "разрушения" бина
    @PreDestroy
    public void destroyBean() {
        System.out.println("LOGGER: Pizza bean was destroyed :(" );
    }


    @Override
    public String nameCookable() {
        return "Pizza pepperoni";
    }

    public String[] cook() {
        return new String[] {"Dough", "Tomatoes", "Tomato Pasta", "Meat", "Cheese"};
    }

    @Override
    public String describe() {
        return "Proof the yeast. Make and knead the pizza dough. Let the dough rise." +
                "Divide the dough into 2 balls. Prep the toppings. Flatten the dough ball, and stretch out into a round:" +
                "and etc...";
    }



    @Override
    public int estimateInRubles() {
        return 400;
    }


}
