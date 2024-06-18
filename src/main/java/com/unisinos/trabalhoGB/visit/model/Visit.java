package com.unisinos.trabalhoGB.visit.model;

import java.util.Date;

import com.unisinos.trabalhoGB.common.model.Person;
import com.unisinos.trabalhoGB.elderly.model.Elderly;

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
	private Date reprovedAt;
	
	@ManyToOne
    @JoinColumn(name="elderly_id")
	private Elderly elderly;
	
	@ManyToOne
    @JoinColumn(name="responsable_id")
	private Person responsable;
}
