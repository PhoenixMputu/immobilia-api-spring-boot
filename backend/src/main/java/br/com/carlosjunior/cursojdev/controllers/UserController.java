package br.com.carlosjunior.cursojdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(value = "/{name}")
	public String test(@PathVariable String name) {

		User usuario = new User();
		usuario.setName(name);
		usuario.setAge(37);
		userRepository.save(usuario);

		return "Salvo com sucesso!";
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<User>> listAll() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
