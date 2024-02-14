package com.example.FinalYearProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FinalYearProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalYearProjApplication.class, args);
	}

}
