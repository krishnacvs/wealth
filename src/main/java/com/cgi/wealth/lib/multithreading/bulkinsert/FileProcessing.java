package com.cgi.wealth.lib.multithreading.bulkinsert;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProcessing {
    public static void main(String[] args) {
        File filePath = new File("c://temp//user");
        File filesList[] = filePath.listFiles();
        int numberOfThreads = 2;
        Thread threads[] = new Thread[numberOfThreads];
        int filesPerThread = filesList.length/numberOfThreads;
        int remainingFiles = filesList.length/numberOfThreads;
        System.out.println(String.format("%s %s",filesPerThread,remainingFiles));
        for(int t=0; t<numberOfThreads; t++){
            int threadNo = t;
            threads[t] = new Thread(){
                @Override
                public void run() {
                    runThread(filesList, threadNo);
                }
            };
        }
        for (Thread t1: threads) {
            t1.start();
        }
        for (Thread t2: threads) {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void runThread(File[] filesList, int threadNo) {
        //System.out.println(Arrays.toString(filesList));
        List<File> inFiles = new ArrayList<>();
        for (int i = 0; i < filesList.length; i++) {
            inFiles.add(filesList[i]);
        }
        for (File file: inFiles) {
            System.out.println(String.format("%s %s",file,Thread.currentThread().getName()));
        }

    }
}
