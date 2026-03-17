package com.url_shortner.shortner.dto;

import java.time.LocalDateTime;

public record ResponseDto(
    String status,
    String shortURL,
    LocalDateTime expiresAt
) {
}
