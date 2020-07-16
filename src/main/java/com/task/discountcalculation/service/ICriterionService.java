package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.DayOfWeekCriterionDto;
import com.task.discountcalculation.dto.DestinationCriterionDto;
import com.task.discountcalculation.entity.criterion.Criterion;
import com.task.discountcalculation.entity.criterion.DayOfWeekCriterion;
import com.task.discountcalculation.entity.criterion.DestinationCriterion;

import java.util.List;
import java.util.Optional;

public interface ICriterionService {

    List<Criterion> getAllCriteria();
    Optional<List<DestinationCriterion>> getAllDestinationCriteria();
    Optional<DestinationCriterion> createDestinationCriterion(DestinationCriterionDto destinationCriterionDto);
    void deleteDestinationCriteria(Long id);
    Optional<List<DayOfWeekCriterion>> getAllDayOfWeekCriteria();
    Optional<DayOfWeekCriterion> createDayOfWeek(DayOfWeekCriterionDto dayOfWeekCriterionDto);
    void deleteDayOfWeekCriteria(Long id);
}
