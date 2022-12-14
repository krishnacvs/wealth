package com.cgi.wealth.lib.multithreading.future;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Asynchronous programming
 * Non blocking code is run on n number of tasks without blocking main thread
 * It will improve performane
 * When task is completed it will notify your main thread
 * Futures
 * You can not forcefully complete the task
 * Multiple future can not be chained together, what next ? Stream
 * Combine multiple future together
 * No Proper Exception handling
 */

@Slf4j
public class WhyNotFuture{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //Thread schedule will control the threads
        Future<List<Integer>> future1 = executor.submit(() -> {
            Thread.sleep(5000);
            System.out.println("Thread: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4);
        });

        Future<List<Integer>> future2 = executor.submit(() -> {
            System.out.println(10/0);
            System.out.println("Thread: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4);
        });

        Future<List<Integer>> future3 = executor.submit(() -> {
            System.out.println("Thread: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4);
        });
        List<Integer> list1 = future1.get();
        System.out.println("List "+list1);
//        List<Integer> list2 = future2.get();
//        System.out.println("List "+list2);
    }
}
