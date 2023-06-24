package com.airsys.airticket.service;

import com.airsys.airticket.entity.Destination;
import com.airsys.airticket.entity.Source;

import java.util.List;

public interface DestinationService {
    Destination saveDestination(Destination destination);


    List<Destination> showDestination();
}
