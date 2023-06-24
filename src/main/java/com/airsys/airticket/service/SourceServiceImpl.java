package com.airsys.airticket.service;

import com.airsys.airticket.entity.Source;
import com.airsys.airticket.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    @Override
    public Source saveSource(Source source) {
        return sourceRepository.save(source);
    }

    @Override
    public List<Source> showSource() {
        return sourceRepository.findAll();
    }
}
