package com.cafeteria.web.controller;

import com.cafeteria.web.model.User;
import com.cafeteria.web.model.dto.AuthenticationDto;
import com.cafeteria.web.model.dto.UserRegistrationDto;
import com.cafeteria.web.service.LoginService;
import com.cafeteria.web.utils.TokenService;
import com.cafeteria.web.utils.UserClient;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String getHomePage() {
        return "home_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return loginService.getLoginPage(model);
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute AuthenticationDto login) {
        return loginService.loginUser(login);
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        return loginService.getRegistrationPage(model);
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute UserRegistrationDto user) {
        return loginService.registerUser(user);
    }


}
