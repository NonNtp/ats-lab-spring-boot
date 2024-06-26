package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.employee.dto.CreateEmployeeRequest;
import com.ats_lab.demo.employee.dto.EmployeeListResponse;
import com.ats_lab.demo.employee.dto.EmployeeResponse;
import com.ats_lab.demo.employee.dto.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Setter(onMethod_ = @Autowired)
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<EmployeeListResponse> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeResponse> getEmployeeByEmpId(@PathVariable Integer empId) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmpId(empId));
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeByEmpCode(@RequestParam String empCode) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeByEmpCode(empCode);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeEntity createdEmployee = employeeService.createEmployee(createEmployeeRequest);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Integer empId, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeEntity updatedEmployee = employeeService.updateEmployee(empId, updateEmployeeRequest);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.noContent().build();
    }

}
