package com.cafeteria.order.controller;

import com.cafeteria.order.model.dto.OrderDto;
import com.cafeteria.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService= orderService;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/latest")
    public OrderDto getLatestOrder(){
       return orderService.getLatestOrder();
    }
}
