package com.url_shortner.shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class ShortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortnerApplication.class, args);
	}

}
