package com.unisinos.trabalhoGB.responsable.model;

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
@DiscriminatorValue("RESPONSABLE")
public class Responsable extends Person {
	
	@OneToMany(mappedBy="responsable")
	private Set<Visit> visits;
}
