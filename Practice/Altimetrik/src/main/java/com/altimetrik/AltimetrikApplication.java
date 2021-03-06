package com.altimetrik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.altimetrik.model")
@ComponentScan("com.altimetrik")
@EnableJpaRepositories("com.altimetrik.repository")
public class AltimetrikApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltimetrikApplication.class, args);
	}

}
