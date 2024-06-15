package com.unisinos.trabalhoGB.nurse.model;

import java.util.Set;

import com.unisinos.trabalhoGB.activity.model.Activity;
import com.unisinos.trabalhoGB.common.model.Person;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("NURSE")
public class Nurse extends Person {

	@OneToMany(mappedBy="nurse")
	private Set<Activity> activities;
}
