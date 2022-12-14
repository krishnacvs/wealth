package com.cgi.wealth.lib.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var processor = new Processor();
        processor.start();

        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutDown();
    }

}

@Slf4j
class Processor extends Thread implements TaskInterface{
    private volatile boolean running = true;

    @Override
    public void run() {
        log.info("Processor::run");
        while(this.running){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info("Processor::run ->Exception");
            }
        }
    }

    public void shutDown(){
        this.running = false;
    }

    @Override
    public void performTask() {
        System.out.println("TaskInterface performTask");
    }
}

interface TaskInterface{
    void performTask();
}