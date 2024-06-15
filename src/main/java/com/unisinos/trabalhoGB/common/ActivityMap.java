package com.unisinos.trabalhoGB.common;

import com.unisinos.trabalhoGB.activity.model.Activity;
import com.unisinos.trabalhoGB.common.dto.ActivityDTO;

public class ActivityMap {

    public static ActivityDTO map(Activity activity) {
        final var dto = new ActivityDTO();
        dto.setId(activity.getId());
        dto.setName(activity.getName());
        dto.setNurseId(activity.getNurse().getId());
        dto.setNurseName(activity.getNurse().getName());
        dto.setElderlyId(activity.getElderly().getId());
        dto.setElderlyName(activity.getElderly().getName());
        dto.setFinished(activity.isFinished());
        dto.setDate(activity.getDate());
        dto.setDescription(activity.getDescription());
        return dto;
    }

}
