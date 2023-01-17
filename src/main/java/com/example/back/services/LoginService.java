package com.example.back.services;

import com.example.back.entities.User;
import com.example.back.interfaces.UserRepository;
import com.example.back.config.MD5Class;
import com.example.back.auth.AuthenticationResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository repository;

    private final TokenService tokenService;

    private final InMemoryUserDetailsManager detailsManager;

    public LoginService(UserRepository repository, TokenService tokenService, InMemoryUserDetailsManager detailsManager) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.detailsManager = detailsManager;
    }

    public ResponseEntity<AuthenticationResponseObject> service(String login, String password) {

        password = MD5Class.MD5(password);

        User user = repository.findByLogin(login);

        if (user == null) {
            throw new BadCredentialsException("Пользователь с таким логином не существует");
        }

        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Неверный логин или пароль! Повторите попытку");
        }

        if (!detailsManager.userExists(login)) {
            detailsManager.createUser(org.springframework.security.core.userdetails.User.withUsername(login)
                    .password("{noop}" + password)
                    .authorities("read")
                    .build());
        }

        return ResponseEntity.ok(
                new AuthenticationResponseObject(tokenService.generateToken(login))
        );
    }
}
