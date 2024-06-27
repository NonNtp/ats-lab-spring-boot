package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.entity.custommodel.EmpPositionCustomEntity;
import com.ats_lab.demo.employee.dto.*;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity createEmployee(CreateEmployeeRequest createEmployeeRequest);
    EmployeeListResponse getAllEmployee();
    EmployeeResponse getEmployeeByEmpId(Integer empId);
    Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode);
    EmployeeEntity updateEmployee(Integer empId, UpdateEmployeeRequest updateEmployeeRequest);
    void deleteEmployee(Integer empId);
    EmpPositionResponse getEmpPosition(String empCode);

}
