package com.mba.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 * 
 * @SpringBootApplication: tell spring this class is starting point of spring
 *                         boot application.
 * 
 * @author MBA
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
