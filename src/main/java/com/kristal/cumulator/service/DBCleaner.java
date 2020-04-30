package com.kristal.cumulator.service;

import com.kristal.cumulator.repository.StreamDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TimerTask;


@Service
public class DBCleaner extends TimerTask {
    @Autowired
    private StreamDataRepository streamDataRepository;

    @Override
    public void run() {
        System.out.println("cleaning up database as it's a continuous stream");
        streamDataRepository.deleteAll();
    }
}
