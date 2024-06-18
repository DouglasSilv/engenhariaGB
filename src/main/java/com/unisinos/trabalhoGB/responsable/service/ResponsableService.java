package com.unisinos.trabalhoGB.responsable.service;

import com.unisinos.trabalhoGB.responsable.model.Responsable;
import com.unisinos.trabalhoGB.responsable.model.ResponsableRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponsableService {

    private final ResponsableRepository repository;

    public ResponsableService(ResponsableRepository repository) {
        this.repository = repository;
    }

    public Responsable findById(String id) {
        return repository.findById(id).orElseThrow();
    }
}
