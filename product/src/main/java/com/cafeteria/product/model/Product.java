package com.cafeteria.product.model;

import com.cafeteria.product.enumerator.ProductEnum;
import com.cafeteria.product.model.dto.ProductCreationRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity(name ="product")
public class Product extends EntityBase {

    public Product(){}

    public Product (ProductCreationRecord productRecord){
        this.productType = productRecord.productType();
        this.calories = productRecord.calories();
        this.description = productRecord.description();
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
