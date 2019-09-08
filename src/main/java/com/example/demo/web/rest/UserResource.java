package com.example.demo.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) throws URISyntaxException {
		User result = this.userService.save(user);
		return ResponseEntity.created(new URI("/user/" + result.getId())).body(result);
	}

}