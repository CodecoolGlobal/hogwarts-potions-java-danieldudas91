package com.codecool.hogwartspotions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.codecool.hogwartspotions.service.JPA")
public class HogwartsPotionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsPotionsApplication.class, args);
	}
}
