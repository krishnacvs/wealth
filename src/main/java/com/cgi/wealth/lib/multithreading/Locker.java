package com.cgi.wealth.lib.multithreading;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Locker {

    private Random random = new Random();
    private Object lock1 = new Object(); // ReentrantLock
    private Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    public void main() {
        System.out.println("Hello");
        LocalDateTime tStart = LocalDateTime.now();
        var t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        t1.start();
        var t2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime tEnd = LocalDateTime.now();
        var duration = Duration.between(tStart, tEnd);
        System.out.println("Process Duration: " + duration.getSeconds());
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }

    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("stageOne Exception");
            }
            this.list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("stageOne Exception");
            }
            this.list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            this.stageOne();
            this.stageTwo();
        }

    }
}
