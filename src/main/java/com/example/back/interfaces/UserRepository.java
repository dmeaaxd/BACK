package com.example.back.interfaces;

import com.example.back.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
