package com.airsys.airticket.model;

import com.airsys.airticket.entity.AirFleet;
import com.airsys.airticket.entity.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookingDto {
    private Long bookingId;
    private String destintion;
    private String source;
    private Long seat;
    private AirFleet airFleet;
    @OneToOne
    private Customer customer;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
    private Date flightSourceDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
    private Date flightDestinationDateTime;
}
