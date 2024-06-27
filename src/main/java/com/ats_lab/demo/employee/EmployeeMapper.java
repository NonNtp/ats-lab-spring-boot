package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.entity.PositionEntity;
import com.ats_lab.demo.common.entity.custommodel.EmpPositionCustomEntity;
import com.ats_lab.demo.employee.dto.EmpPositionResponse;
import com.ats_lab.demo.employee.dto.EmployeeDataResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    EmployeeDataResponse mapEmployeeEntityToEmployeeDataResponse(
            EmployeeEntity employeeEntity
    );

    @Mapping(target = "fullName", expression = "java(getFullName(source.getFirstName(),source.getLastName()))")
    EmpPositionResponse mapEmpPositionCustomEntityToEmpPositionResponse(
            EmpPositionCustomEntity source
    );

    @Mapping(target = "fullName", expression = "java(getFullName(employeeEntity.getFirstName(),employeeEntity.getLastName()))")
//    @Mapping(source = "positionName" , target = "positionName")
//    @Mapping(source = "positionTypeName" , target = "positionTypeName")
    EmpPositionResponse mapEmployeeEntityAndPositionEntityToEmpPositionResponse(
            EmployeeEntity employeeEntity ,
            PositionEntity positionEntity
//            String positionName,
//            String positionTypeName
    );

    default String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}