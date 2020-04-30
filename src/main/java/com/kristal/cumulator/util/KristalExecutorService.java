package com.kristal.cumulator.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class KristalExecutorService {
    private ExecutorService executorService;

    int cores;

    @PostConstruct
    public void init(){
        cores = Runtime.getRuntime().availableProcessors();
        executorService= Executors.newFixedThreadPool(cores);
        log.info("executor service initialized with " + cores + " cores");
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    @PreDestroy
    public void destroy(){
        log.info("shutting down executor service");
        this.executorService.shutdown();
    }
}
