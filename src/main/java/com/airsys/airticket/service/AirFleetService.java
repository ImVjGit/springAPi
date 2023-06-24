package com.airsys.airticket.service;

import com.airsys.airticket.entity.AirFleet;

import java.util.List;

public interface AirFleetService {
    AirFleet saveFleet(AirFleet airFleet);

    List<AirFleet> showAllFleet();
}
