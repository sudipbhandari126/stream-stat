package com.kristal.cumulator.service;

import com.kristal.cumulator.repository.StreamDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TimerTask;


@Service
@Slf4j
public class DBCleaner extends TimerTask {
    @Autowired
    private StreamDataRepository streamDataRepository;

    @Override
    public void run() {
        log.info("cleaning up database as it's a continuous stream");
        streamDataRepository.deleteAll();
    }
}
