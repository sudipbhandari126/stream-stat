package com.kristal.cumulator.util;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class KristalExecutorService {
    private ExecutorService executorService;

    int cores;

    @PostConstruct
    public void init(){
        cores = Runtime.getRuntime().availableProcessors();
        executorService= Executors.newFixedThreadPool(cores);
        System.out.println("executor service initialized with " + cores + " cores");
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}
