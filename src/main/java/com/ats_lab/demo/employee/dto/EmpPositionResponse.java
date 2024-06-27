package com.ats_lab.demo.employee.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmpPositionResponse {
    private Integer empId;
    private String empCode;
    private String fullName;
    private String positionName;
    private String positionTypeName;
}
