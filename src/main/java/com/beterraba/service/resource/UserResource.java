package com.beterraba.service.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beterraba.service.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "88995663645", "senha123");
		return ResponseEntity.ok().body(user);
	}
}
