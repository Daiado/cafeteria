package com.cafeteria.web.service.impl;


import com.cafeteria.web.model.User;
import com.cafeteria.web.model.dto.AuthenticationDto;
import com.cafeteria.web.model.dto.UserRegistrationDto;
import com.cafeteria.web.service.LoginService;
import com.cafeteria.web.utils.TokenService;
import com.cafeteria.web.utils.UserClient;
import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;

@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;

    private final UserClient userClient;

    private final TokenService tokenService;

    public LoginServiceImpl(AuthenticationManager authenticationManager,UserClient userClient,TokenService tokenService){
        this.tokenService = tokenService;
        this.userClient = userClient;
        this.authenticationManager = authenticationManager;
    }



    public String loginUser(AuthenticationDto login, HttpServletResponse response) {

        var credentials = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
        try{
            Authentication auth = this.authenticationManager.authenticate(credentials);
            response.addCookie(tokenService.generateCookie(auth));
        }catch (Exception e){
           return "redirect:/login?error";
        }

        return "redirect:/order";
    }


    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration_page";
    }


    public String getLoginPage(Model model) {
        model.addAttribute("user", new AuthenticationDto());

        return "login_page";
    }

    @Override
    public String registerUser(UserRegistrationDto user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try{
        userClient.createUser(user);
        }catch (FeignException e ){
            return "redirect:/registration?error";
        }
        return "redirect:/login?success";

    }


}
