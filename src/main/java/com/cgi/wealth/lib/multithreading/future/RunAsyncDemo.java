package com.cgi.wealth.lib.multithreading.future;

import com.cgi.wealth.lib.multithreading.entity.AppUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RunAsyncDemo {
    //private UserRepository userRepository;

    public static void main(String[] args) {
        RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
        try {
            runAsyncDemo.saveUsersWithExecutor(new File("MOCK_DATA.json"));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Void saveUsers(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            try {
                List<AppUser> appUsers = mapper
                        .readValue(jsonFile, new TypeReference<List<AppUser>>() {

                        });
                System.out.println("Thread: " + Thread.currentThread().getName());
                appUsers.stream().forEach(System.out::println);
                //userRepository.saveAll(appUsers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return runAsyncFuture.get();
    }

    public Void saveUsersWithExecutor(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            try {
                List<AppUser> appUsers = mapper
                        .readValue(jsonFile, new TypeReference<List<AppUser>>() {

                        });
                System.out.println("Thread: " + Thread.currentThread().getName());
                appUsers.stream().forEach(System.out::println);
                //userRepository.saveAll(appUsers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        },executor);
        return runAsyncFuture.get();
    }
}
