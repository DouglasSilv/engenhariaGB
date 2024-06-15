package com.unisinos.trabalhoGB.elderly.service;

import com.unisinos.trabalhoGB.elderly.model.Elderly;
import com.unisinos.trabalhoGB.elderly.model.ElderlyRepository;
import org.springframework.stereotype.Service;

@Service
public class ElderlyService {

    private final ElderlyRepository repository;

    public ElderlyService(ElderlyRepository repository) {
        this.repository = repository;
    }

    public Elderly findById(String id) {
        return repository.findById(id).orElseThrow();
    }

}
