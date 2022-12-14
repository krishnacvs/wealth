package com.cgi.wealth.lib.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample{
    final ReentrantLock reentrantLock = new ReentrantLock();

    public void performTask() {
        try {
            reentrantLock.lockInterruptibly(); //wait till thread get the lock or till other thread interrupts
            //and you can control further execution from catch block
            try {
                //.....
            } finally {
                reentrantLock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
