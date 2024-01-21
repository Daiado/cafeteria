package com.cafeteria.web.service.impl;

import com.cafeteria.web.enumerator.ProductEnum;
import com.cafeteria.web.model.User;
import com.cafeteria.web.model.dto.OrderDto;
import com.cafeteria.web.service.OrderService;
import com.cafeteria.web.service.ProductService;
import com.cafeteria.web.utils.OrderClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;



@Service
public class OrderServiceImpl implements OrderService {

    private ProductService productService;

    private OrderClient orderClient;

    public OrderServiceImpl(ProductService productService,OrderClient orderClient){
        this.productService = productService;
        this.orderClient = orderClient;
    }


    public String getOrderPage(Model model) {
        model.addAttribute("user",(User) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal());

        model.addAttribute("latestOrder",orderClient.getLatestOrder());
        model.addAttribute("beverages",productService.getProductByType(ProductEnum.BEVERAGE));
        model.addAttribute("mainCourses",productService.getProductByType(ProductEnum.MAIN_COURSE));
        model.addAttribute("order", new OrderDto());

        return "order_page";
    }


    public String saveOrder(OrderDto order) {
        User principal = (User) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();
        order.setUser(principal.getId());
        this.orderClient.createOrder(order);
        return "redirect:/order?success";
    }
}
