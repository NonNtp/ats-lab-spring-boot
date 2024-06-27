package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.repository.EmployeeRepository;
import com.ats_lab.demo.employee.dto.EmployeeDataResponse;
import com.ats_lab.demo.employee.dto.EmployeeListDataResponse;
import com.ats_lab.demo.employee.dto.EmployeeListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    static final Date createdDate = new Date();
    static final Date updatedDate = new Date();

    @BeforeEach
    void setup(){
        employeeService = new EmployeeServiceImpl();
        employeeService.setEmployeeRepository(employeeRepository);
        employeeService.setEmployeeMapper(employeeMapper);
    }

    @Test
    void when_get_all_employee_success(){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(1);
        employeeEntity.setEmpCode("1001");
        employeeEntity.setFirstName("John");
        employeeEntity.setLastName("Smith");
        employeeEntity.setEmail("john.s@aware.co.th");
        employeeEntity.setMobileNumber("0999999999");
        employeeEntity.setGender("M");
        employeeEntity.setCurrentSite("ATS");
        employeeEntity.setPositionId(2);
        employeeEntity.setCreatedDate(createdDate);
        employeeEntity.setCreatedBy("Test");
        employeeEntity.setUpdatedDate(updatedDate);
        employeeEntity.setUpdatedBy("Test");
        employeeEntity.setBase("BANGKOK");

        EmployeeEntity employeeEntity2 = new EmployeeEntity();
        employeeEntity2.setEmpId(2);
        employeeEntity2.setEmpCode("1002");
        employeeEntity2.setFirstName("John");
        employeeEntity2.setLastName("Smith");
        employeeEntity2.setEmail("john.s@aware.co.th");
        employeeEntity2.setMobileNumber("0999999999");
        employeeEntity2.setGender("M");
        employeeEntity2.setCurrentSite("ATS");
        employeeEntity2.setPositionId(2);
        employeeEntity2.setCreatedDate(createdDate);
        employeeEntity2.setCreatedBy("Test");
        employeeEntity2.setUpdatedDate(updatedDate);
        employeeEntity2.setUpdatedBy("Test");
        employeeEntity2.setBase("BANGKOK");

        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities.add(employeeEntity);
        employeeEntities.add(employeeEntity2);

        EmployeeDataResponse employeeResponse = new EmployeeDataResponse();
        employeeResponse.setEmpId(1);
        employeeResponse.setEmpCode("1001");
        employeeResponse.setFirstName("John");
        employeeResponse.setLastName("Smith");
        employeeResponse.setEmail("john.s@aware.co.th");
        employeeResponse.setMobileNumber("0999999999");
        employeeResponse.setGender("M");
        employeeResponse.setCurrentSite("ATS");
        employeeResponse.setPositionId(2);
        employeeResponse.setCreatedDate(createdDate);
        employeeResponse.setCreatedBy("Test");
        employeeResponse.setUpdatedDate(updatedDate);
        employeeResponse.setUpdatedBy("Test");
        employeeResponse.setBase("BANGKOK");

        EmployeeDataResponse employeeResponse2 = new EmployeeDataResponse();
        employeeResponse2.setEmpId(2);
        employeeResponse2.setEmpCode("1002");
        employeeResponse2.setFirstName("John");
        employeeResponse2.setLastName("Smith");
        employeeResponse2.setEmail("john.s@aware.co.th");
        employeeResponse2.setMobileNumber("0999999999");
        employeeResponse2.setGender("M");
        employeeResponse2.setCurrentSite("ATS");
        employeeResponse2.setPositionId(2);
        employeeResponse2.setCreatedDate(createdDate);
        employeeResponse2.setCreatedBy("Test");
        employeeResponse2.setUpdatedDate(updatedDate);
        employeeResponse2.setUpdatedBy("Test");
        employeeResponse2.setBase("BANGKOK");

        List<EmployeeDataResponse> responses = new ArrayList<>();
        responses.add(employeeResponse);
        responses.add(employeeResponse2);

        EmployeeListDataResponse employeeListDataResponse = new EmployeeListDataResponse();
        employeeListDataResponse.setEmployeeDataResponseList(responses);

        EmployeeListResponse expect = new EmployeeListResponse();
        expect.setData(employeeListDataResponse);

        when(employeeRepository.findAll()).thenReturn(employeeEntities);
        EmployeeListResponse actual = employeeService.getAllEmployee();

        assertEquals(expect, actual);
        verify(employeeRepository, times(1)).findAll();
    }

}
