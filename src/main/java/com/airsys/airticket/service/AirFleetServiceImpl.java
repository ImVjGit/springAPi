package com.airsys.airticket.service;

import com.airsys.airticket.entity.AirFleet;
import com.airsys.airticket.repository.AirFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirFleetServiceImpl implements AirFleetService {
    @Autowired private AirFleetRepository airFleetRepository;

    @Override
    public AirFleet saveFleet(AirFleet airFleet) {
        return airFleetRepository.save(airFleet);
    }

    @Override
    public List<AirFleet> showAllFleet() {
        return airFleetRepository.findAll();
    }
}
