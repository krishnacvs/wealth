package com.cgi.wealth.lib.multithreading.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * if return
 *  supplyAsync()
 *      With Executor
 *          Will you provided threads
 *      WithOut Executor
 *          forkjoinpool
 * else
 *  runAsync()
 *      With Executor
 *          Will you provided threads
 *      WithOut Executor
 *          forkjoinpool
 */
public class CompletableFutureDemo {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException{
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("return dummy data");

    }

}

