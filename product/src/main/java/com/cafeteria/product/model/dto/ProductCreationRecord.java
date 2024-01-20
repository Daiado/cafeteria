package com.cafeteria.product.model.dto;

import com.cafeteria.product.enumerator.ProductEnum;

public record ProductCreationRecord(ProductEnum productType,String description,double calories) {
}
