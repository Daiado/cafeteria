package com.cafeteria.web.model.dto;

import java.util.UUID;

public class OrderDto {

    public OrderDto(){};

    private UUID user;


    private UUID beverage;

    private UUID mainCourse;

    private double calories;



    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public UUID getBeverage() {
        return beverage;
    }

    public void setBeverage(UUID beverage) {
        this.beverage = beverage;
    }

    public UUID getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(UUID mainCourse) {
        this.mainCourse = mainCourse;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
