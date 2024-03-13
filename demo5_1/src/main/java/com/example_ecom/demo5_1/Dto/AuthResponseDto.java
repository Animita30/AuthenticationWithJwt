package com.example_ecom.demo5_1.Dto;


import com.example_ecom.demo5_1.Controller.AuthStatus;

public record AuthResponseDto(String token, AuthStatus authStatus){
}
