package com.cafeteria.product.service.impl;

import com.cafeteria.product.enumerator.ProductEnum;
import com.cafeteria.product.model.Product;
import com.cafeteria.product.model.dto.ProductCreationRecord;
import com.cafeteria.product.model.dto.ProductUpdateRecord;
import com.cafeteria.product.repository.ProductRepository;
import com.cafeteria.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProductById(UUID id) {

        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }


    public List<Product> getProductByProductType(ProductEnum productType) {

        return productRepository.findByProductType(productType);
    }

    public void createProduct(ProductCreationRecord productRecord) {

        Product product = new Product(productRecord);
        productRepository.save(product);
    }


    public void deleteProduct(UUID id) {

        productRepository.deleteById(id);
    }


    public void updateProduct(ProductUpdateRecord productRecord) {

         Product product = productRepository.findById(productRecord.id()).orElseThrow(() ->
                 new EntityNotFoundException());

         product.setProductType(productRecord.productType());
         product.setCalories(productRecord.calories());
         product.setDescription(productRecord.description());

         productRepository.save(product);
    }


}
