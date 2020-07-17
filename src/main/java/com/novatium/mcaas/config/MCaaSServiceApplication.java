package com.novatium.mcaas.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.novatium.mcaas.*"})
public class MCaaSServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MCaaSServiceApplication.class, args);
	}

}
