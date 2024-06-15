package com.unisinos.trabalhoGB.nurse.service;

import com.unisinos.trabalhoGB.common.ActivityMap;
import com.unisinos.trabalhoGB.common.dto.ActivityDTO;
import com.unisinos.trabalhoGB.nurse.model.Nurse;
import com.unisinos.trabalhoGB.nurse.model.NurseRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NurseService {

    private final NurseRepository repository;

    public NurseService(NurseRepository repository) {
        this.repository = repository;
    }

    public Nurse findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Set<ActivityDTO> getActivitiesByNurse(String nurseId) {
        return repository.findById(nurseId).orElseThrow().getActivities().stream().map(ActivityMap::map).collect(Collectors.toSet());
    }


}
