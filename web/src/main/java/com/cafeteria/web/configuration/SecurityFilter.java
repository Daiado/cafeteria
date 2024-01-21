package com.cafeteria.web.configuration;

import com.cafeteria.web.utils.TokenService;
import com.cafeteria.web.utils.UserClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.Arrays;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserClient userClient;

    public SecurityFilter(TokenService tokenService,UserClient userClient) {
        this.tokenService = tokenService;
        this.userClient = userClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = null;
        if(request.getCookies()!=null)
        {
            token = Arrays.stream(request.getCookies()).filter(cookie ->
                    cookie.getName().equals("token")).findFirst().get().getValue().toString();
        }
        if(token != null){
            var email = tokenService.validateToken(token);
            UserDetails user = userClient.getUserByEmail(email);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}