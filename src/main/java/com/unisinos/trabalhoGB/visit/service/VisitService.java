package com.unisinos.trabalhoGB.visit.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.visit.model.Visit;
import com.unisinos.trabalhoGB.visit.model.VisitRepository;

@Service
public class VisitService {
	
	@Autowired
	private VisitRepository repository;
	
	public void createVisit() {
		Visit visit = new Visit();
		visit.setId(UUID.randomUUID().toString());
		visit.setAproved(true);
		visit.setDate(new Date());
		visit.setDescription("Visita marcada com o paciente XXXX");
//		visit.setElderly(personService.getElderly("efa4c07a-ba14-479e-a2e7-c7eb75c71b95"));
//		visit.setResponsable(personService.getResponsable("3cd32757-0d75-48b9-bfbe-f62ced27f9df"));
		repository.save(visit);
	}
}