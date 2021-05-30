package br.com.carlosjunior.cursojdev.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GretingsController {

	@RequestMapping(value = "/course")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public String greetingText() {
		return "Curso de API Rest Spring Boot !";
	}

	@RequestMapping(value = "/helloworld/{name}")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public String retornaOlaMundo(@PathVariable String name) {
		return name + ", Hello world";
	}

}
