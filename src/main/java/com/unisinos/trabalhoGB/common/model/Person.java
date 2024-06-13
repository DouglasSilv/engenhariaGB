package com.unisinos.trabalhoGB.common.model;

import java.util.Set;

import com.unisinos.trabalhoGB.activity.model.Activity;
import com.unisinos.trabalhoGB.user.model.User;
import com.unisinos.trabalhoGB.visit.model.Visit;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public abstract class Person {
	
	@Id
	private String id;
	private String name;
	private int age;
	private char gender;
	private String address;
	
	@OneToOne(mappedBy = "person")
	private User user;
}
