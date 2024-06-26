package com.ats_lab.demo.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Date birthDate;
}
