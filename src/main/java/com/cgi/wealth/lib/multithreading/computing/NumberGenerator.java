package com.cgi.wealth.lib.multithreading.computing;

import java.io.IOException;

/**
 Java Multi thread: Fix the code issue ?
 */
public class NumberGenerator {
    public int count = 0;
    public static void main(String[] args) throws IOException {
        NumberGenerator app = new NumberGenerator();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                app.count++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                app.count++;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(app.count);
    }
}
