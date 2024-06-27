package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.repository.EmployeeRepository;
import com.ats_lab.demo.employee.dto.CreateEmployeeDTO;
import com.ats_lab.demo.employee.dto.UpdateEmployeeDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Setter(onMethod_ = @Autowired)
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository ;


    @Override
    public EmployeeEntity createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        log.info("EmployeeServiceImpl.createEmployee");
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmpCode(createEmployeeDTO.getEmpCode());
        employee.setFirstName(createEmployeeDTO.getFirstName());
        employee.setLastName(createEmployeeDTO.getLastName());
        employee.setEmail(createEmployeeDTO.getEmail());
        employee.setMobileNumber(createEmployeeDTO.getMobileNumber());
        employee.setBirthDate(createEmployeeDTO.getBirthDate());
        employee.setGender(createEmployeeDTO.getGender());
        employee.setCurrentSite(createEmployeeDTO.getCurrentSite());
        employee.setPositionId(createEmployeeDTO.getPositionId());
        employee.setBase(createEmployeeDTO.getBase());


        employee.setCreatedDate(new Date());
        employee.setCreatedBy("admin");
        employee.setUpdatedDate(new Date());
        employee.setUpdatedBy("admin");

        log.info("EmployeeServiceImpl.createEmployee save : employeeEntity :: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        log.info("EmployeeServiceImpl.getAllEmployee");
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeByEmpId(Integer empId) {
        log.info("EmployeeServiceImpl.getEmployee with empId : {}", empId);
        return employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode) {
        log.info("EmployeeServiceImpl.getEmployee with empCode : {}", empCode);
        Optional<EmployeeEntity> employee = Optional.ofNullable(employeeRepository.findByEmpCode(empCode));
        return Optional.ofNullable(employee.orElseThrow(() -> new RuntimeException("Employee not found with empCode" + empCode)));
    }

    @Override
    public EmployeeEntity updateEmployee(Integer empId, UpdateEmployeeDTO updateEmployeeDTO) {
        log.info("EmployeeServiceImpl.updateEmployee with empId : {}", empId);
        EmployeeEntity existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        existingEmployee.setFirstName(updateEmployeeDTO.getFirstName());
        existingEmployee.setLastName(updateEmployeeDTO.getLastName());
        existingEmployee.setMobileNumber(updateEmployeeDTO.getMobileNumber());
        existingEmployee.setEmail(updateEmployeeDTO.getEmail());
        existingEmployee.setBirthDate(updateEmployeeDTO.getBirthDate());

        existingEmployee.setUpdatedDate(new Date());
        existingEmployee.setUpdatedBy("admin");

        log.info("EmployeeServiceImpl.updateEmployee Entity : {}", existingEmployee);
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        log.info("EmployeeServiceImpl.deleteEmployee with empId : {}", empId);
        EmployeeEntity existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
        employeeRepository.delete(existingEmployee);
    }


}
