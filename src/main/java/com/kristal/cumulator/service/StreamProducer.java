package com.kristal.cumulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Service
public class StreamProducer {

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    public void generateStream(){
        String stream;
        List<Integer> randomNumberList = new ArrayList<>(5);
        int sum=0;
        Timer timer = new Timer();
        while (true){
            sum=0;
            randomNumberList.clear();
            for (int i=0;i<5;i++){
                int rand =randomNumberGenerator.getRandomNumber();
                sum+= rand;
                randomNumberList.add(rand);
            }
            for (int i: randomNumberList){
                System.out.println(i);
            }
        }


    }


    @PostConstruct
    public void init(){
        Timer timer = new Timer();
        timer.schedule(randomNumberGenerator,200); //5 times a second
    }
}
