package com.practice.calories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CaloriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriesApplication.class, args);
	}

}
