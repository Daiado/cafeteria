package com.cafeteria.product.service;

import com.cafeteria.product.enumerator.ProductEnum;
import com.cafeteria.product.model.Product;
import com.cafeteria.product.model.dto.ProductCreationRecord;
import com.cafeteria.product.model.dto.ProductUpdateRecord;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product getProductById(UUID id);

    List<Product> getProductByProductType(ProductEnum productType);

    void createProduct(ProductCreationRecord productRecord);

    void deleteProduct(UUID id);

    void updateProduct(ProductUpdateRecord productRecord);
}
