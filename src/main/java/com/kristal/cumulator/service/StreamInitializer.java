package com.kristal.cumulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Timer;

@Service
public class StreamInitializer {

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    private StreamDataSaver streamDataSaver;

    @PostConstruct
    public void init(){
        Timer timer = new Timer();
        timer.schedule(randomNumberGenerator,0,200); //5 times a second
        System.out.println("random number generator  initialized for every 200 ms");

        timer.schedule(streamDataSaver,0,1000);
        System.out.println("stream data saver initialized for every 1 sec");
    }
}




