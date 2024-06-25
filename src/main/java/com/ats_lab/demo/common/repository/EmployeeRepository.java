package com.ats_lab.demo.common.repository;

import com.ats_lab.demo.common.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    EmployeeEntity findByEmpCode(String empCode);
}
