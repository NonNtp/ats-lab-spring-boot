package com.ats_lab.demo.common.entity.custommodel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class EmpPositionCustomEntity {
    @Id
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_code", unique = true)
    private String empCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "position_type_name")
    private String positionTypeName;
}
