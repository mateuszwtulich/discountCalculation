package com.task.discountcalculation.repository;

import com.task.discountcalculation.entity.criterion.DayOfBirthCriterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfBirthCriterionRepository extends JpaRepository<DayOfBirthCriterion, Long> {
}
