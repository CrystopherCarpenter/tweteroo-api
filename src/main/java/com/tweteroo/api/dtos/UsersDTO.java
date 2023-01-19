package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsersDTO(@NotBlank String username,

                @NotBlank String avatar) {
}