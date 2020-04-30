package com.kristal.cumulator.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;


@Component
public class RandomNumberGenerator extends TimerTask {
    private int randomNumber;

    private Random random;
    private List<Integer> randomNumberList;


    @Override
    public void run() {
        randomNumber = random.nextInt(100);
        System.out.println("random number generator called=="+randomNumber);
        randomNumberList.add(randomNumber);
    }


    @PostConstruct
    public void init(){
        randomNumberList = new ArrayList<>();
        random = new Random();
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }

    public void clearList() {
        randomNumberList.clear();
    }
}
