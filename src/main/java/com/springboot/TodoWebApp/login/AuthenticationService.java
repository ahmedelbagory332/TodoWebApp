package com.springboot.TodoWebApp.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    // hard code userName and password
    public boolean authenticate(String username,String password) {
        if (username != null){
            return username.equalsIgnoreCase("bego") && password.equalsIgnoreCase("12345");
        }
        return false;
    }
}