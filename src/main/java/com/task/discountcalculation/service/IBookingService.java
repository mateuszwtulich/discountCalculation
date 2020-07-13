package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.BookingDto;

import java.util.Optional;

public interface IBookingService {
    Optional<BookingDto> buyFlight(Long flightId, Long tenantId);
}
