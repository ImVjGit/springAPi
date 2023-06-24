package com.airsys.airticket.controller;

import com.airsys.airticket.entity.Source;
import com.airsys.airticket.service.SourceService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/source")
public class SourceController {
    @Autowired private SourceService sourceService;
    @PostMapping("/saveSource")
    public Source saveSource(@RequestBody Source source){
    return sourceService.saveSource(source);
    }

    @GetMapping("/showSource")
    public List<Source> showSource(){
        return sourceService.showSource();
    }

}
