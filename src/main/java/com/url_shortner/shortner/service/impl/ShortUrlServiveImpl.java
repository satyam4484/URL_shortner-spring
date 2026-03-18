package com.url_shortner.shortner.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.url_shortner.shortner.dto.RequestDto;
import com.url_shortner.shortner.entity.ShortUrl;
import com.url_shortner.shortner.mappers.ShortUrlMapper;
import com.url_shortner.shortner.repository.ShortUrlRepository;
import com.url_shortner.shortner.service.interfaces.ShortUrlService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShortUrlServiveImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;
    private final ShortUrlMapper shortUrlMapper;

    @Override
    public ShortUrl createShortUrl(RequestDto request) {

        // Step 1: Convert DTO → Entity
        ShortUrl shortUrl = shortUrlMapper.toEntity(request);

        System.out.println("Received long URL: " + shortUrl.getLongUrl());

        // Step 2: Generate short code
        String shortCode = generateShortCode();

        // Step 3: Set additional fields
        shortUrl.setShortCode(shortCode);
        shortUrl.setShortUrl("http://localhost:8080/" + shortCode);
        shortUrl.setCreatedAt(LocalDateTime.now());

        // Step 4: Save to DB
        return shortUrlRepository.save(shortUrl);
    }

    @Override
    @Cacheable(value = "urls", key = "#shortCode")
    public String getFullUrl(String shortCode) {

        System.out.println("Fetching from DB..."); // debug

        ShortUrl shortUrl = shortUrlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        return shortUrl.getLongUrl();
    }

    // Utility method
    private String generateShortCode() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 6);
    }
}