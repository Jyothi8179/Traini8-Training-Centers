package com.traning.center.traini8.specification;

import com.traning.center.traini8.dto.TrainingCenterFilterDTO;
import com.traning.center.traini8.entity.TrainingCenter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterSpecification {

    public static Specification<TrainingCenter> getFilterSpecification(TrainingCenterFilterDTO filterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter by centerName
            if (filterDTO.getCenterName() != null && !filterDTO.getCenterName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("centerName"), "%" + filterDTO.getCenterName() + "%"));
            }

            // Filter by centerCode
            if (filterDTO.getCenterCode() != null && !filterDTO.getCenterCode().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("centerCode"), filterDTO.getCenterCode()));
            }

            // Join Address table for city and state
            Join<Object, Object> addressJoin = root.join("address", JoinType.LEFT);

            // Filter by city
            if (filterDTO.getCity() != null && !filterDTO.getCity().isEmpty()) {
                predicates.add(criteriaBuilder.like(addressJoin.get("city"), "%" + filterDTO.getCity() + "%"));
            }

            // Filter by state
            if (filterDTO.getState() != null && !filterDTO.getState().isEmpty()) {
                predicates.add(criteriaBuilder.like(addressJoin.get("state"), "%" + filterDTO.getState() + "%"));
            }

            // Filter by studentCapacity
            if (filterDTO.getStudentCapacity() != null) {
                predicates.add(criteriaBuilder.equal(root.get("studentCapacity"), filterDTO.getStudentCapacity()));
            }

            // Filter by contactEmail
            if (filterDTO.getContactEmail() != null && !filterDTO.getContactEmail().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("contactEmail"), filterDTO.getContactEmail()));
            }

            // Filter by contactPhone
            if (filterDTO.getContactPhone() != null && !filterDTO.getContactPhone().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("contactPhone"), filterDTO.getContactPhone()));
            }

            // Combine all predicates
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
