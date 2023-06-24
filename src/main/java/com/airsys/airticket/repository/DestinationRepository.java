package com.airsys.airticket.repository;

import com.airsys.airticket.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository <Destination,Long>{
    Destination  findByName(String name);
}
