package com.cgi.wealth.lib.multithreading.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SafeApp {
    public static void main(String[] args) {
        LocalDateTime tStart = LocalDateTime.now();
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 50; i++) {
            executor.submit(new CountDownProcessor(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime tend = LocalDateTime.now();
        var duration = Duration.between(tStart, tend);
        System.out.println("Total time taken: "+duration.getSeconds());
    }
}

@Slf4j
class CountDownProcessor implements Runnable {
    private CountDownLatch latch;

    public CountDownProcessor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        log.info("CountDownProcessor::run -> started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.latch.countDown();
    }
}
