package com.example_ecom.demo5_1.Service.auth;

import com.example_ecom.demo5_1.Model.AppUser;
import com.example_ecom.demo5_1.Repository.AppUserRepo;
import com.example_ecom.demo5_1.Service.auth.AuthService;
import com.example_ecom.demo5_1.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepo appUserRepo;
    @Override
    public String login(String username, String password) {
        var authToken= new UsernamePasswordAuthenticationToken(username,password);

        var authenticate=authenticationManager.authenticate(authToken);

        //Generate token
        return JwtUtils.generateToken( ((UserDetails)(authenticate.getPrincipal())).getUsername());
    }

    @Override
    public String signUp(String name, String username, String password) {
        //check whether user already exists or not
        if(appUserRepo.existsByUsername(username)){
            throw new RuntimeException("User already exists");
        }

        //Encode password
        var encodedPassword=passwordEncoder.encode(password);

        //Authorities
        var authorities=new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        //create app user
        var appUser=AppUser.builder().name(name).username(username).password(encodedPassword).authorities(authorities).build();

        //save user
        appUserRepo.save(appUser);

        //generate token
        return JwtUtils.generateToken(username);
    }
}
