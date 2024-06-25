package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.employee.dto.CreateEmployeeDTO;
import com.ats_lab.demo.employee.dto.UpdateEmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity createEmployee(CreateEmployeeDTO createEmployeeDTO);
    List<EmployeeEntity> getAllEmployee();
    EmployeeEntity getEmployeeByEmpId(Integer empId);
    Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode);
    EmployeeEntity updateEmployee(Integer empId, UpdateEmployeeDTO updateEmployeeDTO);
    void deleteEmployee(Integer empId);

}
