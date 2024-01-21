package com.cafeteria.order.model;


import com.cafeteria.order.enumerator.ProductEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;


@Entity(name ="product")
public class Product extends EntityBase {

    public Product(){}

    public Product(UUID id){
        this.setId(id);
    }
    @Enumerated(EnumType.STRING)
    private ProductEnum productType;

    private String description;

    private double calories;

    public ProductEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductEnum productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

}
