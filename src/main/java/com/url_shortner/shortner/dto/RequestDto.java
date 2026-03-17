package com.url_shortner.shortner.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestDto(
    @NotBlank(message = "Long URL must not be blank")
    String longURL
) {}
