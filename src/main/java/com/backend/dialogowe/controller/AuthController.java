package com.backend.dialogowe.controller;

import com.backend.dialogowe.entity.User;
import com.backend.dialogowe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Rejestracja użytkownika
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    // Logowanie użytkownika
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            // Sprawdzenie loginu i hasła
            User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());

            return ResponseEntity.ok("Login successful! Redirecting...");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błędne dane logowania");
        }
    }
}