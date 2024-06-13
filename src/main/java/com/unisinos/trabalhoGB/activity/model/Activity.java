package com.unisinos.trabalhoGB.activity.model;

import java.util.Date;

import com.unisinos.trabalhoGB.elderly.model.Elderly;
import com.unisinos.trabalhoGB.nurse.model.Nurse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Activity {

	@Id
	private String id;
	private String name;
	private String description;
	private Date date;
	private boolean finished;
	
	@ManyToOne
    @JoinColumn(name="elderly_id")
	private Elderly elderly;
	
	@ManyToOne
    @JoinColumn(name="nurse_id")
	private Nurse nurse;
}
