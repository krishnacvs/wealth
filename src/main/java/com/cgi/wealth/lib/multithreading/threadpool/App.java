package com.cgi.wealth.lib.multithreading.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        LocalDateTime tStart = LocalDateTime.now();
        ExecutorService executorService = Executors
                .newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(50, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Process taking more than 50 seconds");
        }
        LocalDateTime tEnd = LocalDateTime.now();
        Duration duration = Duration.between(tStart, tEnd);
        System.out.println("Totat time taken for execurtion: "+duration.getSeconds());
    }
}

@Slf4j
class Processor implements Runnable{
    private final int id;

    public Processor(int id){
        this.id = id;
    }

    public void run() {
        log.info("Starting Process: {}",id);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Ending Process: {}",id);
    }
}