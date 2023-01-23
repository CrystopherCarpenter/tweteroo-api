package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UsersDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.service.UsersService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/sign-up")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void create(@RequestBody @Valid UsersDTO req) {
        service.create(new Users(req));
    }
}
