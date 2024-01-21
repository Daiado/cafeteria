package com.cafeteria.web.service;

import com.cafeteria.web.model.dto.AuthenticationDto;
import com.cafeteria.web.model.dto.UserRegistrationDto;
import org.springframework.ui.Model;


public interface LoginService {

    String loginUser(AuthenticationDto login);

    String getRegistrationPage(Model model);

    String getLoginPage(Model model);

    String registerUser(UserRegistrationDto user);
}
