package com.example_ecom.demo5_1.Service.ForUser;

import com.example_ecom.demo5_1.Dto.LoginDto;
import com.example_ecom.demo5_1.Dto.UserRegistrationDto;

public interface UserService {
    String registerUser(UserRegistrationDto registrationDto);
    String loginUser(LoginDto loginDto);
}
