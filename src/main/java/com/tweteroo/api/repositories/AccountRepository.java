package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUsername(String username);
}
