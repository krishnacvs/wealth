package com.cgi.wealth.lib.multithreading.computing;

public class App {
    public int count = 0;
    public static void main(String[] args) {
        App app = new App();
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
        t1.run();
        t1.setPriority(1);
        t2.run();
        t2.setPriority(10);
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("Count "+app.count);
    }
}
