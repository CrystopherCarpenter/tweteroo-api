package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AccountDTO(@NotBlank String username,

        @NotBlank String avatar) {
}