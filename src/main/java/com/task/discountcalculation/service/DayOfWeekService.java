package com.task.discountcalculation.service;

import java.util.Optional;
import com.task.discountcalculation.entity.DayOfWeek;
import com.task.discountcalculation.repository.DayOfWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DayOfWeekService {
    private DayOfWeekRepository dayOfWeekRepository;

    @Autowired
    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public Optional<List<DayOfWeek>> getAllDaysOfWeek(){
        return Optional.of(dayOfWeekRepository.findAll());
    }
}
