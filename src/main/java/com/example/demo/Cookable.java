package com.example.demo;

public interface Cookable {

    String nameCookable();

    String[] cook(); // Описывает список ингредиентов

    String describe(); // Описывает порядок приготовления блюда

    int estimateInRubles(); // Описывает примерную рыночную стоимость блюда

}
