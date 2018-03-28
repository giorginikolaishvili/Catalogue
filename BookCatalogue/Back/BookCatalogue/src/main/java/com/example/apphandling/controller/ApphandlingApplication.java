package com.example.apphandling.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
public class ApphandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApphandlingApplication.class, args);
	}
}
