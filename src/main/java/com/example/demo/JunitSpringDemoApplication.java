package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitSpringDemoApplication.class, args);
	}
	
	@PostConstruct
	public void welcome() {
		System.out.println("Hello World");
	}

}
