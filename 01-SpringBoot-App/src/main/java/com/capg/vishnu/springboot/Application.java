package com.capg.vishnu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Spring boot Application");
		System.out.println("");
		System.out.println("Hello world ");
	}

}
