package com.kristal.cumulator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StreamInitializer {

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    private StreamDataSaver streamDataSaver;

    @Autowired
    private DBCleaner dbCleaner;

    @PostConstruct
    public void init(){
        Timer timer = new Timer();
        timer.schedule(randomNumberGenerator,0,200); //5 times a second
        log.info("random number generator  initialized for every 200 ms");

        timer.schedule(streamDataSaver,0,1000);
        log.info("stream data saver initialized for every 1 sec");

        timer.schedule(dbCleaner, 1 * 60 *60 *1000);
        log.info("scheduled a job to clean up the db every 5 hours");

    }
}




