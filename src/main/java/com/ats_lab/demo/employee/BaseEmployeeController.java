package com.ats_lab.demo.employee;

import com.ats_lab.demo.employee.dto.EmployeeListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public abstract class BaseEmployeeController {
    @Operation(summary = "API FOR GET ALL EMPLOYEE")
    @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = EmployeeListResponse.class)
            )
    )
    public abstract ResponseEntity<EmployeeListResponse> getAllEmployee();
}
