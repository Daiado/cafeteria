package com.cafeteria.order.model;


import com.cafeteria.order.model.dto.OrderDto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name= "user_order")
public class Order extends EntityBase{

    public Order(){}

    public Order(OrderDto orderDto,double totalCalories){
        this.mainCourse = new Product(orderDto.getMainCourse());
        this.beverage = new Product(orderDto.getBeverage());
        this.user = new User(orderDto.getUser());
        this.totalCalories = totalCalories;
    }

    @ManyToOne
    @JoinColumn
    private Product beverage;

    @ManyToOne
    @JoinColumn
    private Product mainCourse;

    @ManyToOne
    @JoinColumn
    private User user;

    private double totalCalories;

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Product getBeverage() {
        return beverage;
    }

    public void setBeverage(Product beverage) {
        this.beverage = beverage;
    }

    public Product getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(Product mainCourse) {
        this.mainCourse = mainCourse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
