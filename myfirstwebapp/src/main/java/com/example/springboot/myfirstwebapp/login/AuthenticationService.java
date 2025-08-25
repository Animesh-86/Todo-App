package com.example.springboot.myfirstwebapp.login;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUsername = username.equalsIgnoreCase("Animesh");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidUsername && isValidPassword;
    }
}

// HardCoded