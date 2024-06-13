package com.unisinos.trabalhoGB.visit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisinos.trabalhoGB.visit.service.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController {

	@Autowired
	private VisitService service;
	
	@PostMapping
	public void createVisit() {
		service.createVisit();
	}
}
