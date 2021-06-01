package br.com.carlosjunior.cursojdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.cursojdev.entities.User;
import br.com.carlosjunior.cursojdev.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "save/{name}/{age}")
	public String save(@PathVariable String name, @PathVariable String age) {

		User usuario = new User();
		usuario.setName(name);
		usuario.setAge(Integer.parseInt(age));
		userRepository.save(usuario);

		return "Salvo com sucesso!";
	}

	@GetMapping(value = "user/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PostMapping(value = "/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		User newUser = userRepository.save(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<User>> listAll() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<User> delete(@RequestBody User user) {
		userRepository.deleteById(user.getId());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<String>("ID: " + id + " deleted success", HttpStatus.OK);
	}

	 


}
