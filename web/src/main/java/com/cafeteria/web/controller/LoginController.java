package com.cafeteria.web.controller;

import com.cafeteria.web.model.User;
import com.cafeteria.web.model.dto.AuthenticationDto;
import com.cafeteria.web.model.dto.UserRegistrationDto;
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

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final UserClient userClient;

    public LoginController(AuthenticationManager authenticationManager, TokenService tokenService,
                           UserClient userClient) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userClient = userClient;
    }


    @GetMapping("/")
    public String getHomePage() {
        return "home_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new AuthenticationDto());
        return "login_page";
    }

    @PostMapping("/login")
    public String LoginUser(@ModelAttribute AuthenticationDto login) {
        var credentials = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
        Authentication auth = this.authenticationManager.authenticate(credentials);
        return "home_page";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration_page";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute UserRegistrationDto user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userClient.createUser(user);
        return "redirect:/login?success";
    }


}
