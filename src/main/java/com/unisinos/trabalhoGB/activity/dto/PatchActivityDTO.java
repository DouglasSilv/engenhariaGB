package com.unisinos.trabalhoGB.activity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PatchActivityDTO {

    private String id;
    private String name;
    private String description;
    private Date date;

    private String elderlyId;

    private String nurseId;

}
