package com.cafeteria.user.service;

import com.cafeteria.user.model.User;
import com.cafeteria.user.model.dto.UserCreationDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    void createUser(UserCreationDto userCreationDto);

    User getUserByEmail(String email);
}
