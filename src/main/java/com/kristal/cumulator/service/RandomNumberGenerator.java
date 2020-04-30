package com.kristal.cumulator.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.TimerTask;


@Component
public class RandomNumberGenerator extends TimerTask {
    private int randomNumber;

    private Random random;

    @Override
    public void run() {
        System.out.println("random number generator called");
        randomNumber = random.nextInt(100);

    }


    @PostConstruct
    public void init(){
        random = new Random();
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
