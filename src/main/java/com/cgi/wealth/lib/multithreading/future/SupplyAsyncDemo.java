package com.cgi.wealth.lib.multithreading.future;

import com.cgi.wealth.lib.multithreading.entity.AppUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


public class SupplyAsyncDemo {
    //private UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
        try {
            List<String> firstNames = supplyAsyncDemo
                    .saveUsersWithOutExecutor(new File("MOCK_DATA.json"));
            firstNames.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<AppUser> appUser = supplyAsyncDemo
                    .testMethod1(new File("MOCK_DATA.json"));
            appUser.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<String> saveUsersWithOutExecutor(File jsonFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<List<String>> supplyAsyncFuture = CompletableFuture
                .supplyAsync(() -> {
                    List<AppUser> users = null;
                    try {
                        users = mapper
                                .readValue(jsonFile, new TypeReference<List<AppUser>>() {

                                });
                        System.out.println("Thread: " + Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return users;
                }).thenApply(users -> {
                    if (Optional.ofNullable(users).isPresent()) {
                        return users.stream().map(u -> u.getFirst_name()).collect(Collectors.toList());
                    } else {
                        return null;
                    }
                });
        return supplyAsyncFuture.get();
    }

    public List<String> testMethod(File jsonFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<List<String>> future = CompletableFuture
                .supplyAsync(() -> {
                    List<AppUser> users = null;
                    try {
                        users = mapper
                                .readValue(jsonFile, new TypeReference<List<AppUser>>() {

                                });
                        System.out.println("Thread: " + Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return users;
                }).thenApply(users -> {
                    return users.stream().map(u -> u.getFirst_name()).collect(Collectors.toList());
                });
        return future.get();
    }

    public List<AppUser> testMethod1(File jsonFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<List<AppUser>> future = CompletableFuture
                .supplyAsync(() -> {
                    List<AppUser> users = null;
                    try {
                        users = mapper
                                .readValue(jsonFile, new TypeReference<>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return users;
                });
        return future.get();
    }
}
