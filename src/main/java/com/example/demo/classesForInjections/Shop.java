package com.example.demo.classesForInjections;


import com.example.demo.Cookable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


// CONSTRUCTOR INJECTION
// SETTER INJECTION

@Component
public class Shop {

    ArrayList<Cookable> cookableArrayList;

    private DoughManufactury manufactury;


    // Ищет бин DoughManufactury и инжектит
    @Autowired
    public void setManufactury(DoughManufactury manufactury) {
        this.manufactury = manufactury;
    }

    public DoughManufactury getManufactury() {
        return manufactury;
    }

    //
    public Shop(List<Cookable> cookableList) {
        this.cookableArrayList = (ArrayList<Cookable>) cookableList;
    }

    public String getCookableArrayList() {
        return "Beans, that implements Cookable: " + cookableArrayList.toString();
    }

    String estimateFood() {

        int count = 0;
        for (Cookable c : cookableArrayList) {
            count += c.estimateInRubles();
        }
        return "Estimated Price" + count;
    }


    // Выводит содержимое бинов DoughManufactury и бинов реализующих интерфейс Cookable
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cookable c : cookableArrayList) {
            sb.append(c.nameCookable() + ": " + c.describe());
            sb.append("\n");
        }
        sb.append(manufactury.name());
        return sb.toString();
    }


}
