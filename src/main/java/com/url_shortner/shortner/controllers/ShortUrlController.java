package com.url_shortner.shortner.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url_shortner.shortner.dto.RequestDto;
import com.url_shortner.shortner.entity.ShortUrl;
import com.url_shortner.shortner.service.interfaces.ShortUrlService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;
    
    @PostMapping("/api/shorten")
    public ShortUrl createShortUrl(@Valid @RequestBody RequestDto request) {
        System.out.println("Received request to shorten URL: " + request);
        return shortUrlService.createShortUrl(request); 
    }

    @GetMapping("/{shortCode}")
    public String getFullUrl(@PathVariable String shortCode) {
        return shortUrlService.getFullUrl   (shortCode);
    }

}
