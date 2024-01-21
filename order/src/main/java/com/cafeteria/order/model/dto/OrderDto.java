package com.cafeteria.order.model.dto;

import com.cafeteria.order.model.Order;

import java.util.UUID;

public class OrderDto {

    public OrderDto(){};

    public OrderDto(Order order){
        this.id = order.getId();
        this.beverage = order.getBeverage().getId();
        this.mainCourse = order.getMainCourse().getId();
        this.calories = order.getTotalCalories();
        this.user = order.getUser().getId();
    };

    private UUID id;

    private UUID user;

    private UUID beverage;

    private UUID mainCourse;

    private double calories;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

