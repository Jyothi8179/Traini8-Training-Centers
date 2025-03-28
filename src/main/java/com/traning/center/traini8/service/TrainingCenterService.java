package com.traning.center.traini8.service;

import com.traning.center.traini8.dto.TrainingCenterRequestDTO;
import com.traning.center.traini8.entity.TrainingCenter;
import com.traning.center.traini8.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterService(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;
    }

    public TrainingCenter createTrainingCenter(TrainingCenterRequestDTO requestDTO) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(requestDTO.getCenterName());
        trainingCenter.setCenterCode(requestDTO.getCenterCode());
        trainingCenter.setAddress(requestDTO.getAddress());
        trainingCenter.setStudentCapacity(requestDTO.getStudentCapacity());
        trainingCenter.setCoursesOffered(requestDTO.getCoursesOffered());
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond()); // System-generated timestamp
        trainingCenter.setContactEmail(requestDTO.getContactEmail());
        trainingCenter.setContactPhone(requestDTO.getContactPhone());
        return trainingCenterRepository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
}
