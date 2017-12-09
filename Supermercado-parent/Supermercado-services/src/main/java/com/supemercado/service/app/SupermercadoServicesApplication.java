package com.supemercado.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.supermercado" })
@EnableJpaRepositories({ "com.supermercado.model.repository" })
@EntityScan({ "com.supermercado.entities" })
public class SupermercadoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoServicesApplication.class, args);
	}
}
