package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.repository.EmployeeRepository;
import com.ats_lab.demo.employee.dto.CreateEmployeeDTO;
import com.ats_lab.demo.employee.dto.UpdateEmployeeDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Setter(onMethod_ = @Autowired)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository ;


    @Override
    public EmployeeEntity createEmployee(CreateEmployeeDTO createEmployeeDTO) {
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

        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeByEmpId(Integer empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeByEmpCode(String empCode) {
        Optional<EmployeeEntity> employee = Optional.ofNullable(employeeRepository.findByEmpCode(empCode));
        return Optional.ofNullable(employee.orElseThrow(() -> new RuntimeException("Employee not found with empCode" + empCode)));
    }

    @Override
    public EmployeeEntity updateEmployee(Integer empId, UpdateEmployeeDTO updateEmployeeDTO) {
        EmployeeEntity existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));

        existingEmployee.setFirstName(updateEmployeeDTO.getFirstName());
        existingEmployee.setLastName(updateEmployeeDTO.getLastName());
        existingEmployee.setMobileNumber(updateEmployeeDTO.getMobileNumber());
        existingEmployee.setEmail(updateEmployeeDTO.getEmail());
        existingEmployee.setBirthDate(updateEmployeeDTO.getBirthDate());

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


}
