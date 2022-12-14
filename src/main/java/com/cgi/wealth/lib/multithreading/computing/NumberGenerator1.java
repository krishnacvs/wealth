package com.cgi.wealth.lib.multithreading.computing;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Java Multi thread: Fix the code issue ?
 */
@Slf4j
public class NumberGenerator1 implements Runnable{

    public int count = 0;
    private static final int limit = 1000;
    private static final int threadPoolSize = 5;
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new NumberGenerator1());
        }
    }


    @Override
    public void run() {
        while (count < limit) {
            //System.out.println(Thread.currentThread().getName() + " : " + count);
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : " + count);
    }
}
