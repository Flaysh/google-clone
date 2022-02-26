/*Google Clone Application - Main file
* Built with Java & Spring Boot Library
* Written by Itay Flaysher - Software engineer
* 26/02/2022
* */

package com.example.googleclone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GoogleCloneApplication {
//Main function - starts the Spring Service
	public static void main(String[] args) {
		SpringApplication.run(GoogleCloneApplication.class, args);
	}

	//enable cors origin for deployment
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
