package com.unisinos.trabalhoGB.activity.service;

import com.unisinos.trabalhoGB.activity.dto.CreateActivityDTO;
import com.unisinos.trabalhoGB.activity.dto.PatchActivityDTO;
import com.unisinos.trabalhoGB.activity.model.Activity;
import com.unisinos.trabalhoGB.activity.model.ActivityRepository;
import com.unisinos.trabalhoGB.common.dto.ActivityDTO;
import com.unisinos.trabalhoGB.elderly.service.ElderlyService;
import com.unisinos.trabalhoGB.nurse.service.NurseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.unisinos.trabalhoGB.common.ActivityMap.map;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

@Service
public class ActivityService {

    private final ActivityRepository repository;
    private final ElderlyService elderlyService;
    private final NurseService nurseService;

    public ActivityService(
            ActivityRepository repository,
            ElderlyService elderlyService,
            NurseService nurseService
    ) {
        this.repository = repository;
        this.elderlyService = elderlyService;
        this.nurseService = nurseService;
    }

    public void createActivity(CreateActivityDTO dto) {
        final var activity = new Activity();
        activity.setId(UUID.randomUUID().toString());
        activity.setFinished(false);
        activity.setDate(dto.getDate());
        activity.setName(dto.getName());
        activity.setDescription(dto.getDescription());
        activity.setElderly(elderlyService.findById(dto.getElderlyId()));
        activity.setNurse(nurseService.findById(dto.getNurseId()));
        repository.save(activity);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public ActivityDTO patch(PatchActivityDTO activity) {
        final var activityToUpdate = repository.findById(activity.getId()).orElseThrow();
        activityToUpdate.setDate(firstNonNull(activity.getDate(), activityToUpdate.getDate()));
        activityToUpdate.setName(firstNonNull(activity.getName(), activityToUpdate.getName()));
        activityToUpdate.setDescription(firstNonNull(activity.getDescription(), activityToUpdate.getDescription()));
        if (nonNull(activity.getNurseId())) {
            activityToUpdate.setNurse(nurseService.findById(activity.getNurseId()));
        }
        if (nonNull(activity.getElderlyId())) {
            activityToUpdate.setNurse(nurseService.findById(activity.getElderlyId()));
        }
        return map(repository.save(activityToUpdate));
    }

    public void changeStatus(String activityId, boolean isFinished) {
        final var activityToUpdate = repository.findById(activityId).orElseThrow();
        activityToUpdate.setFinished(isFinished);
        repository.save(activityToUpdate);
    }

}
