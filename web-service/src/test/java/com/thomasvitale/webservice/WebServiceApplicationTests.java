package com.thomasvitale.webservice;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenGetRootThenReturnGreeting() {
		webTestClient
				.get()
				.exchange()
				.expectBody(String.class)
				.isEqualTo("Welcome to Barcelona!");
	}

}
