package com.tweteroo.api.models;

import com.tweteroo.api.dtos.UserDTO;

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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Users(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;
}
