package com.cafeteria.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {



    @GetMapping("/login")
    public String showLoginPage(ModelMap model){
        return "welcome";
    }

}