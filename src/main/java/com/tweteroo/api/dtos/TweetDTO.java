package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TwitterDTO(
                @NotBlank String username,
                @NotBlank String avatar,
                @NotBlank String text) {
}