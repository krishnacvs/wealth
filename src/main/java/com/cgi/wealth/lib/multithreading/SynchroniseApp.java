package com.cgi.wealth.lib.multithreading;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchroniseApp {
    private int count = 0;

    @Synchronized
    public void increment(){
        this.count++;
    }

    public static void main(String[] args) {
        SynchroniseApp synchroniseApp = new SynchroniseApp();
        synchroniseApp.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.info("doWork Exception",e.getCause());
        }
        log.info("Count is: {}",count);
    }
}
