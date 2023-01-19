package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TwitterDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Twitter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Twitter(TwitterDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
        this.text = data.text();
    }

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    @Column(length = 280, nullable = false)
    private String text;
}