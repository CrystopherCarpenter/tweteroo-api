package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Twitter;

public interface TwitterRepository extends JpaRepository<Twitter, Long> {
}
