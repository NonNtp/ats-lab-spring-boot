package com.ats_lab.demo.common.repository;

import com.ats_lab.demo.common.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity,Integer> {

    PositionEntity findByPositionId(Integer positionId);

    List<PositionEntity> findByPositionTypeName(String positionTypeName);
}
