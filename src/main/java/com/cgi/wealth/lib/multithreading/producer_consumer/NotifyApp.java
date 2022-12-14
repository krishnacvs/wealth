package com.cgi.wealth.lib.multithreading.producer_consumer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifyApp {
    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }
}

@Data
class Message {
    private String msg;

    public Message(String str) {
        this.msg = str;
    }
}

@Slf4j
class Waiter implements Runnable {

    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        synchronized (message) {
            try {
                log.info("{} waiting to get notified at time {}"
                        , threadName, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                message.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("{} waiter got notified at time {}"
                , threadName, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        log.info("{} processed {}", threadName, message.getMsg());
    }
}

@Slf4j
class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        log.info("{} started", threadName);
        try {
            log.info("{} waiting to get notified at time {}"
                    , threadName, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            Thread.sleep(10000);
            synchronized (msg) {
                msg.setMsg(String.format("%s Notifier work done",threadName));
                msg.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
}