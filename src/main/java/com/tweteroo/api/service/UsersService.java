package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private static UsersRepository repository;

    public void create(Users req) {
        repository.save(req);
    }

    public static List<Users> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}