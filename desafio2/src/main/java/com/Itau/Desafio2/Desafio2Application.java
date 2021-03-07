package com.Itau.Desafio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@SpringBootApplication
@Configuration
public class Desafio2Application {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("https://desafio-it-server.herokuapp.com");
		
		return builder
				.uriTemplateHandler(uriTemplateHandler)
				.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio2Application.class, args);
	}
}