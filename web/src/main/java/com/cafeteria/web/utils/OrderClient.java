package com.cafeteria.web.utils;

import com.cafeteria.web.model.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value="orderClient", url="${services.order-api}")
public interface OrderClient {

    @PostMapping("/")
    OrderDto createOrder(@RequestBody OrderDto orderDto);

    @GetMapping("/latest")
    OrderDto getLatestOrder();
}
