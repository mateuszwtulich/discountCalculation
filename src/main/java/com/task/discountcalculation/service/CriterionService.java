package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.DayOfWeekCriterionDto;
import com.task.discountcalculation.dto.DestinationCriterionDto;
import com.task.discountcalculation.entity.criterion.Criterion;
import com.task.discountcalculation.entity.criterion.DayOfWeekCriterion;
import com.task.discountcalculation.entity.criterion.DestinationCriterion;
import com.task.discountcalculation.repository.DayOfBirthCriterionRepository;
import com.task.discountcalculation.repository.DayOfWeekCriterionRepository;
import com.task.discountcalculation.repository.DayOfWeekRepository;
import com.task.discountcalculation.repository.DestinationCriterionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CriterionService implements ICriterionService {
    private DayOfBirthCriterionRepository dayOfBirthCriterionRepository;
    private DayOfWeekCriterionRepository dayOfWeekCriterionRepository;
    private DestinationCriterionRepository destinationCriterionRepository;
    private DayOfWeekRepository dayOfWeekRepository;
    private List<Criterion> criteria = new ArrayList<>();

    @Autowired
    public CriterionService(DayOfBirthCriterionRepository dayOfBirthCriterionRepository,
                            DayOfWeekCriterionRepository dayOfWeekCriterionRepository,
                            DestinationCriterionRepository destinationCriterionRepository,
                            DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfBirthCriterionRepository = dayOfBirthCriterionRepository;
        this.dayOfWeekCriterionRepository = dayOfWeekCriterionRepository;
        this.destinationCriterionRepository = destinationCriterionRepository;
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public List<Criterion> getAllCriteria(){
        List<Object> criterionList = new ArrayList<>();
        criterionList.addAll(dayOfBirthCriterionRepository.findAll());
        criterionList.addAll(dayOfWeekCriterionRepository.findAll());
        criterionList.addAll(destinationCriterionRepository.findAll());
        List<Criterion> criteria = criterionList.stream().map(c -> (Criterion) c).collect(Collectors.toList());
        return criteria;
    }

    @Override
    public Optional<List<DestinationCriterion>> getAllDestinationCriteria() {
        return Optional.of(destinationCriterionRepository.findAll());
    }

    @Override
    public Optional<DestinationCriterion> createDestinationCriterion(DestinationCriterionDto destinationCriterionDto) {
        DestinationCriterion destinationCriterion = new DestinationCriterion();
        destinationCriterion.setDestination(destinationCriterionDto.getDestination());
        return Optional.of(destinationCriterionRepository.save(destinationCriterion));
    }

    @Override
    public void deleteDestinationCriteria(Long id) {
        destinationCriterionRepository.deleteById(id);
    }

    @Override
    public Optional<List<DayOfWeekCriterion>> getAllDayOfWeekCriteria() {
        return Optional.of(dayOfWeekCriterionRepository.findAll());
    }

    @Override
    public Optional<DayOfWeekCriterion> createDayOfWeek(DayOfWeekCriterionDto dayOfWeekCriterionDto) {
        DayOfWeekCriterion dayOfWeekCriterion = new DayOfWeekCriterion();
        dayOfWeekCriterion.setDayOfWeek(dayOfWeekRepository.findById(dayOfWeekCriterionDto.getDayOfWeekId()).get());
        return Optional.of(dayOfWeekCriterionRepository.save(dayOfWeekCriterion));
    }

    @Override
    public void deleteDayOfWeekCriteria(Long id) {
        dayOfWeekCriterionRepository.deleteById(id);
    }

}
