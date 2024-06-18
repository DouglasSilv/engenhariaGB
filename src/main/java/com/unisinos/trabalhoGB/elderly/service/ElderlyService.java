package com.unisinos.trabalhoGB.elderly.service;

import com.unisinos.trabalhoGB.activity.dto.PersonDTO;
import com.unisinos.trabalhoGB.elderly.model.Elderly;
import com.unisinos.trabalhoGB.elderly.model.ElderlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderlyService {

    private final ElderlyRepository repository;

    public ElderlyService(ElderlyRepository repository) {
        this.repository = repository;
    }

    public Elderly findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<PersonDTO> findAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    private PersonDTO mapToDTO(Elderly elderly) {
        final var person = new PersonDTO();
        person.setId(elderly.getId());
        person.setName(elderly.getName());
        person.setAge(elderly.getAge());
        person.setGender(elderly.getGender());
        person.setAddress(elderly.getAddress());
        return person;
    }


}
