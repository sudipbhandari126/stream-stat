package com.kristal.cumulator.controllers;


import com.kristal.cumulator.models.StatsResponse;
import com.kristal.cumulator.repository.StreamDataRepository;
import com.kristal.cumulator.service.StreamProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;

@RestController
@RequestMapping("/kristal/cumulator")
public class CumulatorController {
    @Autowired
    StreamDataRepository streamDataRepository;

    @Autowired
    private StreamProducer streamProducer;

    @GetMapping
    public ResponseEntity<StatsResponse> fetchStatistics(){
        return new ResponseEntity<StatsResponse>(new StatsResponse(), HttpStatus.OK);
    }

    private void populateStreamData(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int sum=0;
                int randomValue = random.nextInt(100);
                sum+=randomValue;

            }
        };
    }


    @PostConstruct
    public void init(){
        streamProducer.generateStream();
    }



}
