//package com.example_ecom.demo5_1.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    private int quantity;
//}
