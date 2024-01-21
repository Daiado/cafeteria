package com.cafeteria.web.service;

import com.cafeteria.web.enumerator.ProductEnum;
import com.cafeteria.web.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductByType(ProductEnum productType);
}
