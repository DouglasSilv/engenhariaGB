package com.unisinos.trabalhoGB.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.person.model.Person;
import com.unisinos.trabalhoGB.person.model.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public Person getPerson(String id) {
		return repository.getById(id);
	}
}
