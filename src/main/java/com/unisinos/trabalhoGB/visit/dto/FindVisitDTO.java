package com.unisinos.trabalhoGB.visit.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FindVisitDTO {

    private String id;
    private String description;
    private Date date;
    private String elderlyId;
    private String elderlyName;
    private String responsableId;
    private String responsableName;

}
