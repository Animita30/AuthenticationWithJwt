package com.example_ecom.demo5_1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Column(name = "USERNAME")
    private String username;
    private String mobile;
    private String password;


}
