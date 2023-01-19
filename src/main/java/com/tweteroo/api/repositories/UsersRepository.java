package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
