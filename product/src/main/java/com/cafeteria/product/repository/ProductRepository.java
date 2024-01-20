package com.cafeteria.product.repository;

import com.cafeteria.product.enumerator.ProductEnum;
import com.cafeteria.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByProductType(ProductEnum productType);
}
