package com.cgi.wealth.lib.multithreading.future;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Map<String,String>> futureDurationList = new ArrayList<>();
        Map<String,String> futureDurationMap = null;
        for (int i = 0; i < 10; i++) {
            Future<Integer> futureDuration = executor.submit(new CallableProcessor(i));
            futureDurationMap = new HashMap<>();
            try {
                futureDurationMap.put("futureDuration",futureDuration.get().toString());
                futureDurationList.add(futureDurationMap);
            } catch (InterruptedException e) {
                futureDurationMap.put("futureDuration",e.getMessage());
                futureDurationList.add(futureDurationMap);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Map<String,String> ifutureDuration: futureDurationList) {
            log.info("Future duration is: {}",ifutureDuration.get("futureDuration"));
        }

    }


}

@Slf4j
class CallableProcessor implements Callable {

    private int id;

    public CallableProcessor(int i) {
        this.id = i;
    }

    @Override
    public Object call() throws Exception {
        Random random = new Random();
        var tStart = LocalDateTime.now();
        int duration = random.nextInt(10);
        log.info("Starting");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var tEnd = LocalDateTime.now();
        log.info("Finishing");
        return duration;
    }
}