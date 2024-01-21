package com.cafeteria.order.service;

import com.cafeteria.order.model.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    OrderDto getLatestOrder();
}
