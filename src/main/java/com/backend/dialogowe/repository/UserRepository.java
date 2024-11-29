package com.backend.dialogowe.repository;

import com.backend.dialogowe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Znalezienie użytkownika po emailu
    Optional<User> findByEmail(String email);
}
