package com.thomasvitale.webservice;

import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}

@RestController
class GreetingController {

	@GetMapping("/")
	public Mono<String> getGreeting() {
		return Mono.just("Welcome to Barcelona!");
	}

}
