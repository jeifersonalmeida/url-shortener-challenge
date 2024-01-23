package com.br.jeiferson.urlshortenerchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.br.jeiferson.urlshortenerchallenge.repository")
public class UrlShortenerChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerChallengeApplication.class, args);
	}

}
