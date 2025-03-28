package com.traning.center.traini8.controller;

import com.traning.center.traini8.dto.TrainingCenterRequestDTO;
import com.traning.center.traini8.entity.TrainingCenter;
import com.traning.center.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;



    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenterRequestDTO requestDTO) {
        TrainingCenter trainingCenter = trainingCenterService.createTrainingCenter(requestDTO);
        return ResponseEntity.ok(trainingCenter);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(trainingCenters);
    }
}
