package com.ats_lab.demo.position;

import com.ats_lab.demo.common.entity.PositionEntity;
import com.ats_lab.demo.common.repository.PositionRepository;
import com.ats_lab.demo.position.dto.PositionDataResponse;
import com.ats_lab.demo.position.dto.PositionListDataResponse;
import com.ats_lab.demo.position.dto.PositionListResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter(onMethod_ = @Autowired)
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public PositionListResponse getAllPosition(){
        List<PositionEntity> positionEntityList = positionRepository.findAll();

        List<PositionDataResponse> positionDataResponseList = positionEntityList.stream().map(positionEntity -> positionMapper.mapPositionEntityToPositionDataResponse(positionEntity)).toList();

        PositionListDataResponse positionListDataResponse = new PositionListDataResponse();
        positionListDataResponse.setPositionDataResponseList(positionDataResponseList);

        PositionListResponse positionListResponse = new PositionListResponse();
        positionListResponse.setData(positionListDataResponse);

        return positionListResponse;
    }

    @Override
    public PositionListResponse getByPositionTypeName(String positionTypeName) {
        List<PositionEntity> positionEntityList = positionRepository.findByPositionTypeName(positionTypeName);

        List<PositionDataResponse> positionDataResponseList = positionEntityList.stream().map(positionEntity -> positionMapper.mapPositionEntityToPositionDataResponse(positionEntity)).toList();

        PositionListDataResponse positionListDataResponse = new PositionListDataResponse();
        positionListDataResponse.setPositionDataResponseList(positionDataResponseList);

        PositionListResponse positionListResponse = new PositionListResponse();
        positionListResponse.setData(positionListDataResponse);

        return positionListResponse;
    }
}
