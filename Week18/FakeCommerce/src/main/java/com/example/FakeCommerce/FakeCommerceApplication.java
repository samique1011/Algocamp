package com.example.FakeCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableJpaAuditing 
public class FakeCommerceApplication {

	public static void main(String[] args) {
		Dotenv de = Dotenv.configure().ignoreIfMissing().load();
		de.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(FakeCommerceApplication.class, args);
	}

}
