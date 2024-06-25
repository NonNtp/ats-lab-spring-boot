package com.ats_lab.demo.employee;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import com.ats_lab.demo.common.repository.EmployeeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Setter(onMethod_ = @Autowired)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository ;
    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }


}
