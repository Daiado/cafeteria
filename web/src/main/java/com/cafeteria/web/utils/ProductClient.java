package com.cafeteria.web.utils;

import com.cafeteria.web.enumerator.ProductEnum;
import com.cafeteria.web.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="productClient", url="${services.product-api}")
public interface ProductClient {
    @GetMapping("/type")
    List<ProductDto> getProductByType(@RequestParam ProductEnum productType);
}
