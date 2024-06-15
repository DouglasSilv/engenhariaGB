package com.unisinos.trabalhoGB.common.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDTO {

    private String id;
    private String name;
    private String description;
    private Date date;
    private boolean finished;
    private String elderlyId;
    private String elderlyName;
    private String nurseId;
    private String nurseName;

}
