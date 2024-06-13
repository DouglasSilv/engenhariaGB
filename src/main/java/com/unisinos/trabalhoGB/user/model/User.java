package com.unisinos.trabalhoGB.user.model;

import com.unisinos.trabalhoGB.common.model.Person;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user", schema="public")
public class User {

	@Id
	private String id;
	private String username;
	private String password;	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
}
