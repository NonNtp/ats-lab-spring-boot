package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeEntity> getEmployeeByEmpId(@PathVariable Integer empId) {
        EmployeeEntity employee = employeeService.getEmployeeByEmpId(empId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployeeByEmpCode(@RequestParam String empCode) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeByEmpCode(empCode);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(201).body(createdEmployee);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeEntity employee) {
        EmployeeEntity updatedEmployee = employeeService.updateEmployee(empId, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.noContent().build();
    }

}
