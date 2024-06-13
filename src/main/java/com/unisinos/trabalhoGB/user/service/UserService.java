package com.unisinos.trabalhoGB.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.common.model.UserType;
import com.unisinos.trabalhoGB.elderly.model.Elderly;
import com.unisinos.trabalhoGB.user.model.User;
import com.unisinos.trabalhoGB.user.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public void createUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setPassword("senha123");
		user.setUsername("pedro.viegas");
		
		Elderly person = new Elderly();
		person.setAddress("rua dos bobos");
		person.setAge(75);
		person.setGender('M');
		person.setId(UUID.randomUUID().toString());
		person.setName("Pedro Teste");
		
		user.setPerson(person);
		
		this.repository.save(user);
	}
}
