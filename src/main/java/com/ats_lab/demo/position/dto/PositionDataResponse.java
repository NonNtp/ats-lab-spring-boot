package com.ats_lab.demo.position.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PositionDataResponse {

    private Integer positionId;
    private String positionName;
    private String positionTypeName;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
}
