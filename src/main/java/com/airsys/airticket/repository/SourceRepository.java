package com.airsys.airticket.repository;

import com.airsys.airticket.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source,Long> {

    Source findByName(String name);
}
