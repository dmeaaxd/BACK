package com.example.back.services;

import com.example.back.entities.User;
import com.example.back.interfaces.UserRepository;
import com.example.back.config.MD5Class;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository repository;

    public RegistrationService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> service(String login, String password) {

        password = MD5Class.MD5(password);

        if (repository.findByLogin(login) != null) {
            throw new BadCredentialsException("Пользователь уже существует");
        }

        repository.save(new User(login, password));

        return ResponseEntity.ok().build();

    }

}
