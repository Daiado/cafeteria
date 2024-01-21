package com.cafeteria.web.service.impl;

import com.cafeteria.web.enumerator.ProductEnum;
import com.cafeteria.web.model.dto.ProductDto;
import com.cafeteria.web.service.ProductService;
import com.cafeteria.web.utils.ProductClient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductClient productClient;

    public ProductServiceImpl(ProductClient productClient){
        this.productClient = productClient;
    }

    public List<ProductDto> getProductByType(ProductEnum productType){
       return productClient.getProductByType(productType);
    }
}
