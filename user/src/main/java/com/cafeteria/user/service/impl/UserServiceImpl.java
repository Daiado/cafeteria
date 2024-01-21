package com.cafeteria.user.service.impl;

import com.cafeteria.user.model.User;
import com.cafeteria.user.model.dto.UserCreationDto;
import com.cafeteria.user.repository.UserRepository;
import com.cafeteria.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(UserCreationDto userCreationDto) {
        User user = new User(userCreationDto);
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
       return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException());
    }


}
