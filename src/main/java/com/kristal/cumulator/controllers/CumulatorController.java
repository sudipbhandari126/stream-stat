package com.kristal.cumulator.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kristal/cumulator")
public class CumulatorController {

    @GetMapping
    public ResponseEntity<String> fetchStatistics(){
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }
}
