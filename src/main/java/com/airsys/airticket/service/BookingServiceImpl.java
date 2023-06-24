package com.airsys.airticket.service;

import com.airsys.airticket.entity.*;
import com.airsys.airticket.exception.ResourceNotFoundException;
import com.airsys.airticket.exception.SourceDestinationError;
import com.airsys.airticket.model.BookingDto;
import com.airsys.airticket.repository.*;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Builder
public class BookingServiceImpl implements BookingService {


    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private AirFleetRepository fleetRepository;

//    @Autowired
//    private MyDestination myDestination;
//
//    @Autowired
//    private MySource mySource;

    @Override
    public Booking book(BookingDto savedBooking, Long customerId, Long fleetId) throws SourceDestinationError {
        Booking saved = null;
        Booking b = new Booking();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with UserId " + customerId));

        Source ssname = sourceRepository.findByName(savedBooking.getSource());
        Destination ddname = destinationRepository.findByName(savedBooking.getDestintion());

        //TODO seat allotment with fleet
        String s = ssname.getName();
        String d = ddname.getName();

        String airsource = s.toLowerCase();
        String airdestination = d.toLowerCase();


        AirFleet airFleet = fleetRepository.findById(fleetId)
                .orElseThrow(() -> new ResourceNotFoundException("No AirFleet found with --> " + fleetId));
        String FleetName = airFleet.getFleetName();

        //total seat
        Long totalSeat1 = airFleet.getSeat();

        Long selectedSeats = savedBooking.getSeat();
        Long availbleSeat = null;
        if (totalSeat1 > 0) {
            availbleSeat = totalSeat1 - selectedSeats;
            airFleet.setSeat(availbleSeat);
            System.out.println(airFleet.getSeat());
        }
        System.out.println(totalSeat1);
        System.out.println(availbleSeat);

//        if(airsource=="pune"){
//            airFleet.getFleetName();
//        }


//        ArrayList<Long> totalSeat = new ArrayList<Long>(100);
//        for (Long i : totalSeat) {
//            totalSeat.add(i);
//            System.out.println(totalSeat+"A");
//        }
//myPrice=2800L;
        if (airsource != airdestination) {
            if (airsource.equals("pune") && airdestination.equals("mumbai") || airdestination.equals("pune") && airsource.equals("mumbai")) {
                b.setPrice(2800L * (savedBooking.getSeat()) );
            } else if (airsource.equals("pune") && airdestination.equals("delhi") || airdestination.equals("pune") && airsource.equals("delhi")) {
                b.setPrice(6800L * (savedBooking.getSeat()) );
            } else if (airsource.equals("pune") && airdestination.equals("goa") || airdestination.equals("pune") && airsource.equals("goa")) {
                b.setPrice(4800L * (savedBooking.getSeat()) );
            } else if (airsource.equals("pune") && airdestination.equals("bangalore") || airdestination.equals("pune") && airsource.equals("bangalore")) {
                b.setPrice(4800L * (savedBooking.getSeat()) );
            }
        } else {
            throw new SourceDestinationError("Source & destination cannot be same");
        }


        Date flightSourceDateTime = savedBooking.getFlightSourceDateTime();
        Date flightDestinationDateTime = savedBooking.getFlightDestinationDateTime();

        //TODO time validation
        if (flightSourceDateTime != flightDestinationDateTime || !(flightSourceDateTime.after(flightDestinationDateTime))
                || !(flightDestinationDateTime.after(flightSourceDateTime))) {
            b.setFlightSourceDateTime(flightSourceDateTime);
            b.setFlightDestinationDateTime(flightDestinationDateTime);
        } else {
            throw new SourceDestinationError("Enter Valid Source & destination Time");
        }
        b.setCustomer(customer);
        b.setSource(ssname);
        b.setDestintion(ddname);
        b.setAirFleet(AirFleet.builder()
                .fleetName(FleetName)
                .seat(selectedSeats)
                .fleetId(airFleet.getFleetId())
                .build());


        saved = bookingRepository.save(b);


//flightSourceDateTime.equals(savedBooking.getFlightSourceDateTime()) &&
//                flightDestinationDateTime.equals(savedBooking.getFlightDestinationDateTime())
        return saved;

    }

    @Override
    public Booking getBookedTicket(Long bookingId) {
        Booking bookedDb = bookingRepository.findById(bookingId).get();
        return bookedDb;
    }

}