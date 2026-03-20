package com.avantika.blogapi;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.avantika.blogapi.repository")
@EntityScan(basePackages = "com.avantika.blogapi.entity")
public class BlogapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogapiApplication.class, args);
	}

}
