package com.cafeteria.user.controller;

import com.cafeteria.user.model.User;
import com.cafeteria.user.model.dto.UserCreationDto;
import com.cafeteria.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCreationDto userCreationDto){
        userService.createUser(userCreationDto);
    }

    @GetMapping("/validate")
    public User getUserByEmail(@RequestParam String email){
        return this.userService.getUserByEmail(email);
    }
}
