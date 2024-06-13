package com.unisinos.trabalhoGB.elderly.model;

import java.util.Set;

import com.unisinos.trabalhoGB.activity.model.Activity;
import com.unisinos.trabalhoGB.common.model.Person;
import com.unisinos.trabalhoGB.visit.model.Visit;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ELDERLY")
public class Elderly extends Person {

	@OneToMany(mappedBy="elderly")
	private Set<Visit> visits;
	
	@OneToMany(mappedBy="elderly")
	private Set<Activity> activities;
}
