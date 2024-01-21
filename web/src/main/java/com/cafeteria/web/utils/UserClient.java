package com.cafeteria.web.utils;

import com.cafeteria.web.model.User;
import com.cafeteria.web.model.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value="userClient", url="${services.user-api}")
public interface UserClient {
    @PostMapping("/")
    void createUser(@RequestBody UserRegistrationDto userRegistrationDto);

    @GetMapping("/validate")
    User getUserByEmail(@RequestParam String email);
}

