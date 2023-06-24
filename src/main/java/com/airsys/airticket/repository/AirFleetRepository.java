package com.airsys.airticket.repository;

import com.airsys.airticket.entity.AirFleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirFleetRepository extends JpaRepository<AirFleet,Long> {

   public AirFleet findByFleetName(String fleetName);
}
