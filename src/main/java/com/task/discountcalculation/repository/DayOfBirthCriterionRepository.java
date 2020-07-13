package com.task.discountcalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfBirthCriterionRepository extends JpaRepository<DayOfBirthCriterionRepository, Long> {
}
