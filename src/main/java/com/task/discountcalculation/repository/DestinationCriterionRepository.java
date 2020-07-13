package com.task.discountcalculation.repository;

import com.task.discountcalculation.entity.criterion.DestinationCriterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationCriterionRepository extends JpaRepository<DestinationCriterion, Long> {
}
