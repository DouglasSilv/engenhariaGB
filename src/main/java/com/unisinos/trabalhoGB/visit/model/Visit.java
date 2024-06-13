package com.unisinos.trabalhoGB.visit.model;

import java.util.Date;

import com.unisinos.trabalhoGB.person.model.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Visit {

	@Id
	private String id;
	private String description;
	private Date date;
	private boolean aproved;
	
	@ManyToOne
    @JoinColumn(name="elderly_id")
	private Person elderly;
	
	@ManyToOne
    @JoinColumn(name="responsable_id")
	private Person responsable;
}
