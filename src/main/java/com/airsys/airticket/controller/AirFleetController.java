package com.airsys.airticket.controller;

import com.airsys.airticket.entity.AirFleet;
import com.airsys.airticket.service.AirFleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirBooking/AirFleet")
public class AirFleetController {
    @Autowired private AirFleetService airFleetService;

    @PostMapping("/saveFleet")
    public AirFleet saveAirFleet(@RequestBody AirFleet airFleet){
        AirFleet savedAirFleet=airFleetService.saveFleet(airFleet);
        return savedAirFleet;
    }

    @GetMapping("/showFleet")
    public List<AirFleet> showAllAirFleet(){
        List<AirFleet> showAirFleet=airFleetService.showAllFleet();
        return showAirFleet;
    }
}
