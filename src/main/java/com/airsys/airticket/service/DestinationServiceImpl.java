package com.airsys.airticket.service;

import com.airsys.airticket.entity.Destination;
import com.airsys.airticket.entity.Source;
import com.airsys.airticket.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> showDestination() {
        return destinationRepository.findAll();
    }
}
