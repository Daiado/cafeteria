package com.cafeteria.web.controller;


import com.cafeteria.web.model.dto.OrderDto;
import com.cafeteria.web.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService =orderService;
    }

    @GetMapping
    public String getOrderPage(Model model) {
        return orderService.getOrderPage(model);
    }

    @PostMapping
    public String order(@ModelAttribute OrderDto order,Model model) {
        return orderService.saveOrder(order);
    }

}
