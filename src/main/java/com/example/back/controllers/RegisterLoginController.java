package com.example.back.controllers;

import com.example.back.entities.User;
import com.example.back.services.LoginService;
import com.example.back.services.RegistrationService;
import com.example.back.auth.AuthenticationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegisterLoginController {

    private final RegistrationService registrationService;

    private final LoginService loginService;

    public RegisterLoginController(RegistrationService registrationService, LoginService loginService) {
        this.registrationService = registrationService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseObject> login(@RequestBody User user) {
        if (user.getLogin() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

        return loginService.service(user.getLogin(), user.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getLogin() == null || user.getPassword() == null) {
            throw new BadCredentialsException("Неверный логин или пароль! Повторите попытку");
        }

        return registrationService.service(user.getLogin(), user.getPassword());
    }
}
