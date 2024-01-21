package com.cafeteria.web.service;

import com.cafeteria.web.model.dto.OrderDto;
import org.springframework.ui.Model;

public interface OrderService {

    public String getOrderPage(Model model);

    public String saveOrder(OrderDto order);
}
