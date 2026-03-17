package com.url_shortner.shortner.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.url_shortner.shortner.dto.RequestDto;
import com.url_shortner.shortner.entity.ShortUrl;

@Mapper(componentModel="spring")
public interface ShortUrlMapper {
    @Mapping(target = "shortCode", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "longUrl", source = "longURL")
    @Mapping(target = "shortUrl", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "expiresAt", ignore = true)
    ShortUrl toEntity(RequestDto request);


}       


