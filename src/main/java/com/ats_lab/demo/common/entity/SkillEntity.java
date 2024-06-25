package com.ats_lab.demo.common.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "skills")
public class SkillEntity {

    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;

    @Column(name = "skill_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String skillName;

    @Column(name = "skill_type_name")
    private String skillTypeName;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;
}
