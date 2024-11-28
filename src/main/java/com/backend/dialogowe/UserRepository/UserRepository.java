package com.backend.dialogowe.UserRepository;


import com.backend.dialogowe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

