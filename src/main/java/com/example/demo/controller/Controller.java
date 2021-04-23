package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/hello")
	public String hello(@RequestParam (name="name", defaultValue = "Default") String name) {
		return String.format("Hello %s", name);
	}

}
