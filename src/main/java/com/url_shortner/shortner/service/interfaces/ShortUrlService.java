package com.url_shortner.shortner.service.interfaces;

import com.url_shortner.shortner.dto.RequestDto;
import com.url_shortner.shortner.entity.ShortUrl;

public interface ShortUrlService {
    ShortUrl createShortUrl(RequestDto request);
    String getFullUrl(String shortCode);
}