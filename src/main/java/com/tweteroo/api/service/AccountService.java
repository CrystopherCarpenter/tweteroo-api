package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Account;
import com.tweteroo.api.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private static AccountRepository repository;

    public void create(Account req) {
        repository.save(req);
    }

    public static Account findByUsername(String username) {
        return repository.findByUsername(username).get(0);
    }
}