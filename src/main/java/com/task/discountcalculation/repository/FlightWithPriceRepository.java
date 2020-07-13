package com.task.discountcalculation.repository;

import com.task.discountcalculation.entity.FlightWithPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightWithPriceRepository extends JpaRepository<FlightWithPrice, Long> {
}
