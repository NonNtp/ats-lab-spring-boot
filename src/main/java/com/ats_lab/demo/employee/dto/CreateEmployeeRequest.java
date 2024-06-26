package com.ats_lab.demo.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeRequest {
    private String empCode;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Date birthDate;
    private String gender;
    private String currentSite;
    private Integer positionId;
    private String base;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
}
