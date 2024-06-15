package com.unisinos.trabalhoGB.user.service;

import java.util.UUID;

import com.github.javafaker.Faker;
import com.unisinos.trabalhoGB.nurse.model.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.elderly.model.Elderly;
import com.unisinos.trabalhoGB.user.model.User;
import com.unisinos.trabalhoGB.user.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public void createElderlyUser() {
		final var faker = new Faker();
		final var name = faker.name();
		final var user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setPassword("senha123");
		user.setUsername(name.username());

		final var person = new Elderly();
		person.setAddress(faker.address().fullAddress());
		person.setAge(faker.number().numberBetween(50, 110));
		person.setGender('M');
		person.setId(UUID.randomUUID().toString());
		person.setName(name.name());

		user.setPerson(person);

		this.repository.save(user);
	}

	public void createNurseUser() {
		final var faker = new Faker();
		final var name = faker.name();
		final var user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setPassword("senha123");
		user.setUsername(name.username());

		final var person = new Nurse();
		person.setAddress(faker.address().fullAddress());
		person.setAge(faker.number().numberBetween(18, 60));
		person.setGender('F');
		person.setId(UUID.randomUUID().toString());
		person.setName(name.name());

		user.setPerson(person);

		this.repository.save(user);
	}
}
