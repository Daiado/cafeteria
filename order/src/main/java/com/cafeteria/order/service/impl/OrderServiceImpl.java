package com.cafeteria.order.service.impl;


import com.cafeteria.order.model.Order;
import com.cafeteria.order.model.Product;
import com.cafeteria.order.model.dto.OrderDto;
import com.cafeteria.order.repository.OrderRepository;
import com.cafeteria.order.service.OrderService;
import com.cafeteria.order.util.ProductClient;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository,ProductClient productClient){
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Product beverage = productClient.getProductById(orderDto.getBeverage());
        Product mainCourse = productClient.getProductById(orderDto.getMainCourse());
        Order order = orderRepository.save(new Order(orderDto,beverage.getCalories()+mainCourse.getCalories()));
        return new OrderDto(order);
    }

    public OrderDto getLatestOrder() {

        Order order = orderRepository.findFirstByOrderByCreatedDateDesc();
        if(Objects.isNull(order)){
            return new OrderDto();
        }
        return  new OrderDto(order);
    }
}
