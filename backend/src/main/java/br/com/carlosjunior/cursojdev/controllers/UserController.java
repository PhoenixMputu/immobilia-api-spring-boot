package br.com.carlosjunior.cursojdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.cursojdev.entities.User;
import br.com.carlosjunior.cursojdev.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{name}")
	public String test(@PathVariable String name) {
		
		User usuario = new User();
		usuario.setName(name);
		usuario.setAge(37);
		userRepository.save(usuario);
		
		return "Salvo com sucesso!";
	}
	
}
