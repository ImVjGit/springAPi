package com.airsys.airticket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue
    private Long bookingId;
    @OneToOne
    private AirFleet airFleet;
    private Long price;
    @OneToOne
    private Customer customer;

//    private MySource mysource;
//    private MyDestination  myDestination;
    @OneToOne
    private Destination destintion;
    @OneToOne
    private Source source;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
    private Date flightSourceDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
    private Date flightDestinationDateTime;
}
