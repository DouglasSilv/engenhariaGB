package com.unisinos.trabalhoGB.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisinos.trabalhoGB.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public String ping() {
		return "ping";
	}

	@PostMapping("/elderly")
	public void createElderly() {
		service.createElderlyUser();
	}

	@PostMapping("/nurse")
	public void createNurse() {
		service.createNurseUser();
	}
}
