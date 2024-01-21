package com.cafeteria.order.util;

import com.cafeteria.order.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value="productClient", url="${services.product-api}")
public interface ProductClient {

    @GetMapping("/")
    Product getProductById(@RequestParam UUID id);
}
