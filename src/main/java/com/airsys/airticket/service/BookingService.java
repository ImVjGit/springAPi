package com.airsys.airticket.service;

import com.airsys.airticket.entity.Booking;
import com.airsys.airticket.exception.SourceDestinationError;
import com.airsys.airticket.model.BookingDto;

import java.util.List;

public interface BookingService {
    Booking book(BookingDto booking, Long customerId,Long fleetId) throws SourceDestinationError;

    Booking getBookedTicket(Long bookingId);
}
