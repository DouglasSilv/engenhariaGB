package com.unisinos.trabalhoGB.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.person.model.Person;
import com.unisinos.trabalhoGB.person.model.UserType;
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
		
		Person person = new Person();
		person.setAddress("rua dos bobos");
		person.setAge(75);
		person.setGender('M');
		person.setId(UUID.randomUUID().toString());
		person.setName("Pedro Teste");
		person.setType(UserType.ELDERLY);
		
		user.setPerson(person);
		
		this.repository.save(user);
	}
}
