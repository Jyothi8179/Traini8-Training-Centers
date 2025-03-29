package com.traning.center.traini8.service;

import com.traning.center.traini8.dto.TrainingCenterFilterDTO;
import com.traning.center.traini8.dto.TrainingCenterRequestDTO;
import com.traning.center.traini8.entity.TrainingCenter;
import com.traning.center.traini8.repository.TrainingCenterRepository;
import com.traning.center.traini8.specification.TrainingCenterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

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

    public Page<TrainingCenter> filterTrainingCenters(TrainingCenterFilterDTO filterDTO, Pageable pageable) {
        return trainingCenterRepository.findAll(
                TrainingCenterSpecification.getFilterSpecification(filterDTO), pageable
        );
    }


    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
}
