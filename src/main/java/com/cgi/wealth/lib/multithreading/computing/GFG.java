package com.cgi.wealth.lib.multithreading.computing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GFG {

    // Starting counter
    int counter = 1;

    static int N;

    private StringBuffer stringPool = new StringBuffer();
    // Function to print odd numbers
    public void printB()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {

                // If count is even then print
                while (counter % 2 == 0) {

                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println("A");
                stringPool.append("A");
                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    public void printA()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {

                // If count is odd then print
                while (counter % 2 == 1) {

                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println("B");
                stringPool.append("B");
                // Increment counter
                counter++;

                // Notify to 2nd thread
                notify();
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given Number N
        N = 10;

        // Create an object of class
        GFG mt = new GFG();

        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.printA();
            }
        });

        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printB();
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
