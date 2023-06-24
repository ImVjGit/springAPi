package com.airsys.airticket.controller;

import com.airsys.airticket.entity.Booking;
import com.airsys.airticket.exception.SourceDestinationError;
import com.airsys.airticket.model.BookingDto;
import com.airsys.airticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirBooking/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/welcome")
    public String greet() {
        return "Welcome";
    }

    @PostMapping("/book/customerId/{customerId}/airfleetid/{fleetId}")
    public Booking book(@RequestBody BookingDto booking,
                        @PathVariable Long customerId,
                        @PathVariable Long fleetId) throws SourceDestinationError {
        Booking booked = bookingService.book(booking,customerId,fleetId);
        return booked;
    }

    @GetMapping("/ticket/{bookingId}")
    public Booking getBookedTicket(@PathVariable Long bookingId){
        Booking bookedTicket = bookingService.getBookedTicket(bookingId);
        return bookedTicket;
    }
}
