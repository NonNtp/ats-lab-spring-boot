package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.employee.dto.EmployeeDataResponse;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDataResponse mapEmployeeEntityToEmployeeDataResponse(
            EmployeeEntity employeeEntity
    );
}