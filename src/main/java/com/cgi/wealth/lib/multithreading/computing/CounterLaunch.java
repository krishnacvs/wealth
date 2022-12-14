package com.cgi.wealth.lib.multithreading.computing;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java Multi thread: Fix the code issue ?
 */
public class CounterLaunch {
    public int count = 0;
    private static final int threadPoolSize = 5;
    public static void main(String[] args) throws IOException {
        CounterLaunch app = new CounterLaunch();
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            Thread t1 = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    app.count++;
                }
            });
            executorService.submit(t1);
        }
        System.out.println(app.count);
    }
}
