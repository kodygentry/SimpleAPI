package com.ey.BankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ey")
@EntityScan("com.ey.models")
@EnableJpaRepositories("com.ey.repositories")
public class BankingAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	// I put this comment for lolz

}
