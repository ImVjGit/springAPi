package com.airsys.airticket.service;

import com.airsys.airticket.entity.Source;

import java.util.List;

public interface SourceService {


    Source saveSource(Source source);

    List<Source> showSource();
}
