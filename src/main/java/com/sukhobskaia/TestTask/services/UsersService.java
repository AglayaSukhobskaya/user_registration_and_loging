package com.sukhobskaia.TestTask.services;

import com.sukhobskaia.TestTask.models.User;
import com.sukhobskaia.TestTask.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository peopleRepository;

    @Autowired
    public UsersService(UsersRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public User findOne(String username) {
        Optional<User> person = peopleRepository.findByUsername(username);
        return person.orElse(null);
    }
}
