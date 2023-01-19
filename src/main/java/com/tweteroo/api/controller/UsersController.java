package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UsersDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public String create(@RequestBody @Valid UsersDTO req) {
        repository.save(new Users(req));
        return ("OK");
    }
}
