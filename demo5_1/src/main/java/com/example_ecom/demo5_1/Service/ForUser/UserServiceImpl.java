package com.example_ecom.demo5_1.Service.ForUser;

import com.example_ecom.demo5_1.Dto.LoginDto;
import com.example_ecom.demo5_1.Dto.UserRegistrationDto;
import com.example_ecom.demo5_1.Model.User;
import com.example_ecom.demo5_1.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public String registerUser(UserRegistrationDto registrationDto){
//        if(userRepo.existsByUserName(registrationDto.getUsername())){
//            return "Username is already exist!";
        User user=new User();

        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setMobile(registrationDto.getMobile());
        userRepo.save(user);
        return "Registered successfully";


    }
    @Override
    public String loginUser(LoginDto loginDto){
        User user=userRepo.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Implement token generation logic and return the token
        return "generatedAuthToken";
    }
}
