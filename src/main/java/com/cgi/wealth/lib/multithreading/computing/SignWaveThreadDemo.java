package com.cgi.wealth.lib.multithreading.computing;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SignWaveThreadDemo {

    private Random random = new Random();

    private Lock lock = new ReentrantLock();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    public static void main(String[] args) {
        SignWaveThreadDemo signWaveThreadDemo = new SignWaveThreadDemo();
        System.out.println("Hello");
        LocalDateTime tStart = LocalDateTime.now();
        var t1 = new Thread(() -> signWaveThreadDemo.process());
        t1.start();
        var t2 = new Thread(() -> signWaveThreadDemo.process());
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
        System.out.println("List1: " + signWaveThreadDemo.list1.size() + "; List2: " + signWaveThreadDemo.list2.size());
    }

    public void stageOne() {
        lock.lock();
        try {
            System.out.println(1);
            this.list1.add(random.nextInt(100));
        } catch (Exception e) {
            System.out.println("stageOne Exception");
        } finally {
            lock.unlock();
        }
    }

    public void stageTwo() {
        lock.lock();
        try {
            System.out.println(0);
            this.list2.add(random.nextInt(100));
        } catch (Exception e) {
            System.out.println("stageOne Exception");
        } finally {
            lock.unlock();
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            this.stageOne();
            this.stageTwo();
        }
    }
}