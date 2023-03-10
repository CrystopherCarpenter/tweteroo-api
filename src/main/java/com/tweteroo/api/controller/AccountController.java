package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.AccountDTO;
import com.tweteroo.api.models.Account;
import com.tweteroo.api.service.AccountService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/sign-up")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void create(@RequestBody @Valid AccountDTO req) {
        service.create(new Account(req));
    }
}
