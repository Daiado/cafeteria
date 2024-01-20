package com.cafeteria.product.model.dto;

import com.cafeteria.product.enumerator.ProductEnum;

import java.util.UUID;

public record ProductUpdateRecord(UUID id, ProductEnum productType, String description,double calories) {
}
