package com.auth.user_auth.repository;

import com.auth.user_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    // Optional: Useful additions
    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}

