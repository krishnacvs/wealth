package com.cgi.wealth.lib.multithreading.runnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnonymousApp {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    log.info("MyRunner::run -> start");
                    for (int i = 0; i < 10; i++) {
                        log.info("Hello {}", i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            log.info("MyRunner::run -> exception {}", e.getCause());
                        }
                    }
                }

            }
        }
        );
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    log.info("MyRunner::run -> start");
                    for (int i = 0; i < 10; i++) {
                        log.info("Hello {}", i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            log.info("MyRunner::run -> exception {}", e.getCause());
                        }
                    }
                }

            }
        });
        t2.start();
    }
}
