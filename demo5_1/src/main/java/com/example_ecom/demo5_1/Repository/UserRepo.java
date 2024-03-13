package com.example_ecom.demo5_1.Repository;

import com.example_ecom.demo5_1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    //boolean existsByUserName(String );
}
