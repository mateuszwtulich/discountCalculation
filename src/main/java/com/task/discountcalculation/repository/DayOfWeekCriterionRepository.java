package com.task.discountcalculation.repository;

import com.task.discountcalculation.entity.criterion.DayOfWeekCriterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfWeekCriterionRepository extends JpaRepository<DayOfWeekCriterion, Long> {
}
