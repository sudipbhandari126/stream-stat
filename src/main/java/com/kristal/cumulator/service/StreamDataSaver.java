package com.kristal.cumulator.service;

import com.kristal.cumulator.models.entities.StreamData;
import com.kristal.cumulator.repository.StreamDataRepository;
import com.kristal.cumulator.util.KristalExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

@Service
public class StreamDataSaver extends TimerTask {

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    @Autowired
    private KristalExecutorService kristalExecutorService;

    @Autowired
    private StreamDataRepository streamDataRepository;

    private Timer timer;


    @Override
    public void run() {
        List<Integer> randomNumberList = randomNumberGenerator.getRandomNumberList();
        kristalExecutorService.getExecutorService().submit(()->{
            saveToDb(randomNumberList);
        });
        randomNumberGenerator.clearList();
    }

    private void saveToDb(List<Integer> randomNumberList) {
        Integer sum = randomNumberList.stream().reduce(0, (a, b) -> a + b);
        String collect = randomNumberList.stream().
                map(String::valueOf).
                collect(Collectors.joining(","));
        StreamData streamData = new StreamData();
        streamData.setNumberStream(collect);
        streamData.setSum(sum);
        streamDataRepository.save(streamData);

    }
}
