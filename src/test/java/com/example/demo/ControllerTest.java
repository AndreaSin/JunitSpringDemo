package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.demo.controller.Controller;

@WebMvcTest(Controller.class)
@ExtendWith(SpringExtension.class)
class ControllerTest {
	
	// Unit test senza Spring
	// Creo un istanza della classe controller per usare il suo metodo hello
	// mi aspetto che passando World il risultato sia Hello World
	/*
	@Test
	void testHello() {
		Controller c = new Controller();
		String response = c.hello("World");
		assertEquals("Hello World", response);
	}
	*/
	
	
	// permette di mockare funzioni da mvc come get e post
	@Autowired
	private MockMvc mvc;

	@Test
	void testHello() throws Exception {
		 
		// creo una richiesta get	
		RequestBuilder request = MockMvcRequestBuilders.get("/hello");
		// e la simulo con il mock
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Hello Default", result.getResponse().getContentAsString());
	}
	
	// un altro modo, piu conciso
	@Test
	void testHelloWithName() throws Exception { 
		mvc.perform(get("/hello?name=World"))
			.andExpect(content().string("Hello World"));
	}
	
}
