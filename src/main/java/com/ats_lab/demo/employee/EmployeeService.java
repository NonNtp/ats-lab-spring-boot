package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployee();
    EmployeeEntity getEmployeeByEmpId(Integer empId);
    Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode);
    EmployeeEntity updateEmployee(Integer empId, EmployeeEntity employee);
    void deleteEmployee(Integer empId);

}
