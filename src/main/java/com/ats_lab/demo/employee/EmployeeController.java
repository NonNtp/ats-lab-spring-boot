package com.ats_lab.demo.employee;

import com.ats_lab.demo.employee.dto.EmployeeListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter(onMethod_ = @Autowired)
@Tag(name = "EMPLOYEE")
public class EmployeeController extends BaseEmployeeController {

    EmployeeService employeeService ;

    @Override
    @GetMapping("/employee")
    public ResponseEntity<EmployeeListResponse> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
}
