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
    public Iterable<StreamData> get(){
        return streamDataRepository.findAll();
    }




}
