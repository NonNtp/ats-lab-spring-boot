package com.ats_lab.demo.position.dto;

import lombok.Data;

import java.util.List;

@Data
public class PositionListDataResponse {
    private List<PositionDataResponse> positionDataResponseList;
}
