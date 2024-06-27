package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.entity.PositionEntity;
import com.ats_lab.demo.common.entity.custommodel.EmpPositionCustomEntity;
import com.ats_lab.demo.common.repository.EmpPositionCustomRepository;
import com.ats_lab.demo.common.repository.EmployeeRepository;
import com.ats_lab.demo.common.repository.PositionRepository;
import com.ats_lab.demo.employee.dto.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Setter(onMethod_ = @Autowired)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    private EmpPositionCustomRepository empPositionCustomRepository;

    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeEntity createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmpCode(createEmployeeRequest.getEmpCode());
        employee.setFirstName(createEmployeeRequest.getFirstName());
        employee.setLastName(createEmployeeRequest.getLastName());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setMobileNumber(createEmployeeRequest.getMobileNumber());
        employee.setBirthDate(createEmployeeRequest.getBirthDate());
        employee.setGender(createEmployeeRequest.getGender());
        employee.setCurrentSite(createEmployeeRequest.getCurrentSite());
        employee.setPositionId(createEmployeeRequest.getPositionId());
        employee.setBase(createEmployeeRequest.getBase());


        employee.setCreatedDate(new Date());
        employee.setCreatedBy("admin");
        employee.setUpdatedDate(new Date());
        employee.setUpdatedBy("admin");

        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeListResponse getAllEmployee() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        List<EmployeeDataResponse> employeeDataResponseList = employeeEntityList.stream().map(employeeEntity -> employeeMapper.mapEmployeeEntityToEmployeeDataResponse(employeeEntity)).toList();

        EmployeeListDataResponse employeeListDataResponse = new EmployeeListDataResponse();
        employeeListDataResponse.setEmployeeDataResponseList(employeeDataResponseList);

        EmployeeListResponse employeeListResponse = new EmployeeListResponse();
        employeeListResponse.setData(employeeListDataResponse);

        return employeeListResponse;
    }

    @Override
    public EmployeeResponse getEmployeeByEmpId(Integer empId) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElseThrow(null);

        if (employeeEntity != null) {
            employeeResponse.setData(employeeMapper.mapEmployeeEntityToEmployeeDataResponse(
                    employeeEntity
            ));
        }
        return employeeResponse;
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode) {
        Optional<EmployeeEntity> employee = Optional.ofNullable(employeeRepository.findByEmpCode(empCode));
        return Optional.ofNullable(employee.orElseThrow(() -> new RuntimeException("Employee not found with empCode" + empCode)));
    }

    @Override
    public EmployeeEntity updateEmployee(Integer empId, UpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeEntity existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        existingEmployee.setFirstName(updateEmployeeRequest.getFirstName());
        existingEmployee.setLastName(updateEmployeeRequest.getLastName());
        existingEmployee.setMobileNumber(updateEmployeeRequest.getMobileNumber());
        existingEmployee.setEmail(updateEmployeeRequest.getEmail());
        existingEmployee.setBirthDate(updateEmployeeRequest.getBirthDate());

        existingEmployee.setUpdatedDate(new Date());
        existingEmployee.setUpdatedBy("admin");

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        EmployeeEntity existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
        employeeRepository.delete(existingEmployee);
    }

    @Override
    public EmpPositionResponse getEmpPosition(String empCode) {

        EmpPositionCustomEntity empPositionCustomEntity = empPositionCustomRepository.findByEmpCode(empCode);

        return employeeMapper.mapEmpPositionCustomEntityToEmpPositionResponse(empPositionCustomEntity);
    }

    @Override
    public EmpPositionResponse getEmpPositionByEmpId(Integer empId) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmpId(empId);
        PositionEntity positionEntity = positionRepository.findByPositionId(employeeEntity.getPositionId());

        return employeeMapper.mapEmployeeEntityAndPositionEntityToEmpPositionResponse(employeeEntity , positionEntity);
//        return employeeMapper.mapEmployeeEntityAndPositionEntityToEmpPositionResponse(employeeEntity , positionEntity.getPositionName() , positionEntity.getPositionTypeName());
    }
}
