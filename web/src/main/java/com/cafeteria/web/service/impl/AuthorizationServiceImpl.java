package com.cafeteria.web.service.impl;


import com.cafeteria.web.utils.UserClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationServiceImpl implements UserDetailsService {


    private final UserClient userClient;

    public AuthorizationServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userClient.getUserByEmail(email);

    }
}
