package com.cafeteria.product.controller;

import com.cafeteria.product.enumerator.ProductEnum;
import com.cafeteria.product.model.Product;
import com.cafeteria.product.model.dto.ProductCreationRecord;
import com.cafeteria.product.model.dto.ProductUpdateRecord;
import com.cafeteria.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService =productService;
    }

    @GetMapping
    public Product getProductById(@RequestParam UUID id){
        return  productService.getProductById(id);
    }

    @GetMapping("/type")
    public List<Product> getProductByType(@RequestParam ProductEnum productType){
        return  productService.getProductByProductType(productType);
    }

    @PostMapping()
    public void createProduct(@RequestBody ProductCreationRecord productRecord){
        productService.createProduct(productRecord);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam UUID id){
        productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRecord productUpdateRecord){
        productService.updateProduct(productUpdateRecord);
    }


}
