package com.example_ecom.demo5_1.Repository;

import com.example_ecom.demo5_1.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser,String> {
    boolean existsByUsername(String username);

    Optional<AppUser> findByUsername(String username);
}
