package com.example_ecom.demo5_1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class AppUser {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

}
