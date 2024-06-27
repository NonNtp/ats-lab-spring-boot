package com.ats_lab.demo.position;

import com.ats_lab.demo.common.entity.PositionEntity;
import com.ats_lab.demo.position.dto.PositionDataResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PositionMapper {
    PositionDataResponse mapPositionEntityToPositionDataResponse(
            PositionEntity positionEntity
    );
}
