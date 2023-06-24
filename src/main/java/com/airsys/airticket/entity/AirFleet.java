package com.airsys.airticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.Destination;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirFleet {
    @Id
    @GeneratedValue
    private Long fleetId;
    private String fleetName;
    @Column(scale = 100 )
    private Long seat;
//    @OneToOne
//    private Booking booking;
//    @Embedded
//    private AirDestintion airDestintion;
//    @Embedded
//    private AirSource airSource;
//    private Date flightSourceDateTime;
//    private Date flightDestinationDateTime;

}
