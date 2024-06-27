package com.ats_lab.demo.position;

import com.ats_lab.demo.position.dto.PositionListResponse;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Setter(onMethod_ = @Autowired)
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<PositionListResponse> getAllPosition() {
        return ResponseEntity.ok(positionService.getAllPosition());
    }

    @GetMapping("/getbytype")
    public ResponseEntity<PositionListResponse> getByPositionTypeName(@RequestParam String PositionTypeName){
        return ResponseEntity.ok(positionService.getByPositionTypeName(PositionTypeName));
    }
}
