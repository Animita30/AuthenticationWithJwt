package com.example_ecom.demo5_1.Controller;

import com.example_ecom.demo5_1.Dto.LoginDto;
import com.example_ecom.demo5_1.Dto.UserRegistrationDto;
import com.example_ecom.demo5_1.Model.User;
import com.example_ecom.demo5_1.Service.ForUser.UserService;
import com.example_ecom.demo5_1.Service.ForUser.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    //@Autowired

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        System.out.println(registrationDto.toString());
        return ResponseEntity.ok(userService.registerUser(registrationDto));
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {

        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }
}
