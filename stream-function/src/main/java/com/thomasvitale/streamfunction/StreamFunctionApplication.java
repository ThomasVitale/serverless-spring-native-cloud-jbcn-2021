package com.thomasvitale.streamfunction;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StreamFunctionApplication {

	private static final Logger log = LoggerFactory.getLogger(StreamFunctionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StreamFunctionApplication.class, args);
	}

	@Bean
	Function<Instrument,String> uppercase() {
		return instrument -> {
			log.info("Converting {} to uppercase...", instrument.name());
			return instrument.name().toUpperCase();
		};
	}

	@Bean
	Function<Flux<String>, Flux<Skill>> sentence() {
		return flux -> flux.map(instrument -> {
			log.info("Building sentence for skill...");
			return new Skill("I can play the " + instrument);
		});
	}

}

record Instrument(String name) {}
record Skill(String message) {}