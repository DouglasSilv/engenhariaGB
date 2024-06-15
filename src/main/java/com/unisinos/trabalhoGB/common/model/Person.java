package com.unisinos.trabalhoGB.common.model;

import com.unisinos.trabalhoGB.user.model.User;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;
}
