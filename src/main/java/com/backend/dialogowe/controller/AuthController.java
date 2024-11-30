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
    public ResponseEntity<Object> login(@RequestBody User user) {
        try {
            // Sprawdzenie loginu i hasła
            User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());

            // Zwrócenie danych użytkownika po udanym logowaniu
            return ResponseEntity.ok().body(new UserResponse(
                    loggedInUser.getFirstName(),
                    loggedInUser.getLastName(),
                    loggedInUser.getEmail()
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błędne dane logowania");
        }
    }

    // Klasa pomocnicza do zwrócenia danych użytkownika
    public static class UserResponse {
        private String firstName;
        private String lastName;
        private String email;

        public UserResponse(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }
}
