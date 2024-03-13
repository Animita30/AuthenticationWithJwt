package com.example_ecom.demo5_1.Service.auth;

public interface AuthService {
    String login(String username, String password);

    String signUp(String name, String username, String password);
}
