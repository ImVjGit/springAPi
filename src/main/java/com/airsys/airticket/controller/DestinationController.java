package com.airsys.airticket.controller;

import com.airsys.airticket.entity.Destination;
import com.airsys.airticket.entity.Source;
import com.airsys.airticket.service.DestinationService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/destination")
public class DestinationController {
@Autowired private DestinationService destinationService;
    @PostMapping("/saveDestination")
    public Destination saveDestination(@RequestBody Destination destination){
        Destination destination1=destinationService.saveDestination(destination);
        return destination1;
    }


    @GetMapping("/showDestination")
    public List<Destination> showDestination(){

        return destinationService.showDestination();
    }

}
