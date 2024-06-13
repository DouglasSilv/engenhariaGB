package com.unisinos.trabalhoGB.person.model;

import java.util.Set;

import com.unisinos.trabalhoGB.user.model.User;
import com.unisinos.trabalhoGB.visit.model.Visit;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	private String id;
	private String name;
	private int age;
	private char gender;
	private String address;

	@Enumerated(EnumType.STRING)
	private UserType type;
	
	@OneToOne(mappedBy = "person")
	private User user;

	@OneToMany(mappedBy="elderly")
	private Set<Visit> elderlyVisits;
	
	@OneToMany(mappedBy="responsable")
	private Set<Visit> responsableVisits;
}
