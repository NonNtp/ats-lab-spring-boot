package com.ats_lab.demo.common.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "employee_skill")
public class EmployeeSkillEntity {

    @Id
    @Column(name = "emp_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empSkillId;

    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "skill_id")
    private Integer skill_id;

    @Column(name = "skill_level")
    private Integer skillLevel;

    @Column(name = "skill_desc")
    private String skillDesc;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;
}
