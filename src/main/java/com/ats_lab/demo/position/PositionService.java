package com.ats_lab.demo.position;

import com.ats_lab.demo.position.dto.PositionListResponse;

public interface PositionService {

    PositionListResponse getAllPosition();

    PositionListResponse getByPositionTypeName(String positionTypeName);

}
