package com.task.discountcalculation.service;

import com.task.discountcalculation.entity.criterion.Criterion;
import com.task.discountcalculation.repository.DayOfBirthCriterionRepository;
import com.task.discountcalculation.repository.DayOfWeekCriterionRepository;
import com.task.discountcalculation.repository.DestinationCriterionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterionService implements ICriterionService {
    private DayOfBirthCriterionRepository dayOfBirthCriterionRepository;
    private DayOfWeekCriterionRepository dayOfWeekCriterionRepository;
    private DestinationCriterionRepository destinationCriterionRepository;

    @Autowired
    public CriterionService(DayOfBirthCriterionRepository dayOfBirthCriterionRepository,
                            DayOfWeekCriterionRepository dayOfWeekCriterionRepository,
                            DestinationCriterionRepository destinationCriterionRepository) {
        this.dayOfBirthCriterionRepository = dayOfBirthCriterionRepository;
        this.dayOfWeekCriterionRepository = dayOfWeekCriterionRepository;
        this.destinationCriterionRepository = destinationCriterionRepository;
    }

    public List<Criterion> getAllCriteria(){
        List<Object> criterionList = new ArrayList<>();
        criterionList.addAll(dayOfBirthCriterionRepository.findAll());
        criterionList.addAll(dayOfWeekCriterionRepository.findAll());
        criterionList.addAll(destinationCriterionRepository.findAll());
        List<Criterion> criteria = criterionList.stream().map(c -> (Criterion) c).collect(Collectors.toList());
        return criteria;
    }
}
