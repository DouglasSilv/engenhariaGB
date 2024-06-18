package com.unisinos.trabalhoGB.visit.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateVisitDTO {

    private String description;
    private Date date;
    private String elderlyId;
    private String responsableId;

}
