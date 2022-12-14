package com.cgi.wealth.lib.multithreading.producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class WaiterApp {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WaiterApp waiterApp = new WaiterApp();
                    waiterApp.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WaiterApp waiterApp = new WaiterApp();
                    waiterApp.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
    }

    private void producer() throws InterruptedException {
        synchronized (this){
            log.info("Producer thread running....");
            wait();
            log.info("Producer Resumed...");
        }
    }

    private void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            log.info("Waiting for the return key");
            scanner.nextLine();
            log.info("consumer thread running....");
            notify();
            Thread.sleep(5000);
        }
    }

}
