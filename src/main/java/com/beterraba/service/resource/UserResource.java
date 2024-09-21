package com.beterraba.service.resource;

import com.beterraba.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beterraba.service.entities.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User userData) {
		User newUser = service.insert(userData);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newUser);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User data) {
		User user = service.update(id,data);
		return ResponseEntity.ok().body(user);
	}
}
