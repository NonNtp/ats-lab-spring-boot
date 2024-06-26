package com.ats_lab.demo.employee.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeListDataResponse {
    private List<EmployeeDataResponse> employeeDataResponseList ;
}
