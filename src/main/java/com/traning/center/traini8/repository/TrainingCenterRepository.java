package com.traning.center.traini8.repository;

import com.traning.center.traini8.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>, JpaSpecificationExecutor<TrainingCenter> {
}
