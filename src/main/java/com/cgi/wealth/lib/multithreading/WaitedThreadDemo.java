package com.cgi.wealth.lib.multithreading;



import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitedThreadDemo {
    public static void main(String[] args) {
        BinaryProcess binaryProcess = new BinaryProcess();
        System.out.println("Hello");
        LocalDateTime tStart = LocalDateTime.now();
        var t1 = new Thread(new Runnable() {
            public void run() {
                binaryProcess.process();
            }
        });
        t1.start();
        var t2 = new Thread(new Runnable() {
            public void run() {
                binaryProcess.process();
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
        binaryProcess.finished();
    }
}

class BinaryProcess {

    private Random random = new Random();

    private Lock lock = new ReentrantLock();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne() {
        lock.lock();
        try {
            Thread.sleep(1);
            this.list1.add(random.nextInt(100));
            System.out.println(1);
        } catch (InterruptedException e) {
            System.out.println("stageOne Exception");
        } finally {
            lock.unlock();
        }
    }

    public void stageTwo() {
        lock.lock();
        try {
            Thread.sleep(1);
            this.list2.add(random.nextInt(100));
            System.out.println(0);
        } catch (InterruptedException e) {
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

    public void finished() {
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }
}
