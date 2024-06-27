package com.unisinos.trabalhoGB.visit.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.unisinos.trabalhoGB.elderly.service.ElderlyService;
import com.unisinos.trabalhoGB.responsable.service.ResponsableService;
import com.unisinos.trabalhoGB.visit.dto.CreateVisitDTO;
import com.unisinos.trabalhoGB.visit.dto.FindVisitDTO;
import org.springframework.stereotype.Service;

import com.unisinos.trabalhoGB.visit.model.Visit;
import com.unisinos.trabalhoGB.visit.model.VisitRepository;

import static java.util.Objects.isNull;

@Service
public class VisitService {

	private final VisitRepository repository;
	private final ElderlyService elderlyService;
	private final ResponsableService responsableService;

    public VisitService(VisitRepository repository, ElderlyService elderlyService, ResponsableService responsableService) {
        this.repository = repository;
        this.elderlyService = elderlyService;
        this.responsableService = responsableService;
    }

	public List<FindVisitDTO> findAll(String elderlyId, String responsableId) {
		return repository.findAll()
				.stream()
				.filter(item ->
						(isNull(elderlyId) || elderlyId.equals(item.getElderly().getId()))
						&& (isNull(responsableId) || responsableId.equals(item.getResponsable().getId()))
						&& item.isAproved()
				)
				.map(this::mapToDto)
				.toList();
	}

    public void createVisit(CreateVisitDTO dto) {
		Visit visit = new Visit();
		visit.setId(UUID.randomUUID().toString());
		visit.setAproved(false);
		visit.setDate(dto.getDate());
		visit.setDescription(dto.getDescription());
		visit.setElderly(elderlyService.findById(dto.getElderlyId()));
		visit.setResponsable(responsableService.findById(dto.getResponsableId()));
		repository.save(visit);
	}

	public void reprove(String id) {
		final var visit = repository.findById(id).orElseThrow();
		visit.setReprovedAt(new Date());
		repository.save(visit);
	}

	public void approve(String id) {
		final var visit = repository.findById(id).orElseThrow();
		visit.setAproved(true);
		repository.save(visit);
	}

	public List<FindVisitDTO> findAllWaitingApproval() {
		return repository.findAllByAprovedIsFalseAndReprovedAtIsNull()
				.stream()
				.map(this::mapToDto)
				.toList();
	}

	private FindVisitDTO mapToDto(Visit visit) {
		final var dto = new FindVisitDTO();
		dto.setDate(visit.getDate());
		dto.setDescription(visit.getDescription());
		dto.setElderlyId(visit.getElderly().getId());
		dto.setElderlyName(visit.getElderly().getName());
		dto.setResponsableId(visit.getResponsable().getId());
		dto.setResponsableName(visit.getResponsable().getName());
		dto.setId(visit.getId());
		return dto;
	}
}