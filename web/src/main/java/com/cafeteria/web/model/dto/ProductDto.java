package com.cafeteria.web.model.dto;

import com.cafeteria.web.enumerator.ProductEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class ProductDto {

    private UUID id;

    @Enumerated(EnumType.STRING)
    private ProductEnum productType;

    private String description;

    private double calories;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
