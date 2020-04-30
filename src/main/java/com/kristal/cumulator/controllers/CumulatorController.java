package com.kristal.cumulator.controllers;


import com.kristal.cumulator.models.StatsResponse;
import com.kristal.cumulator.models.entities.StreamData;
import com.kristal.cumulator.repository.StreamDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/kristal/cumulator")
public class CumulatorController {
    @Autowired
    private StreamDataRepository streamDataRepository;


    @GetMapping
    public ResponseEntity<StatsResponse> fetchStatistics(){
        return new ResponseEntity<StatsResponse>(new StatsResponse(), HttpStatus.OK);
    }

    @GetMapping("/samples")
    public ResponseEntity<StatsResponse> get(){
        Integer last5MinutesSum = findStat(5);
        Integer last10MinutesSum = findStat(5);
        Integer last30MinutesSum = findStat(5);
        StatsResponse statsResponse = new StatsResponse();
        statsResponse.setLast5MinutesSum(last5MinutesSum);
        statsResponse.setLast10MinutesSum(last10MinutesSum);
        statsResponse.setLast30MinutesSum(last30MinutesSum);
        return new ResponseEntity<>(statsResponse,HttpStatus.OK);
    }

    private Integer findStat(int delayMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -delayMinutes);
        return streamDataRepository.findByCreatedAtGreaterThan(cal.getTime()).stream()
                .map(each -> each.getSum())
                .reduce(0, (a, b) -> a + b);
    }


}
