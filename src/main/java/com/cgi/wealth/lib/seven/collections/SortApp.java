package com.cgi.wealth.lib.seven.collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortApp {
    public static void main(String[] args) {
        SortApp sortApp = new SortApp();
        List<User> userList = sortApp.createArrayList();
        userList.forEach(System.out::println);
        Collections.sort(userList, (o1, o2) -> {
            if (Integer.valueOf(o1.getId()) == Integer.valueOf(o2.getId())){
                return 0;
            } else if (Integer.valueOf(o1.getId()) < Integer.valueOf(o2.getId())){
                return 1;
            } else {
                return -1;
            }
        });
        userList.forEach(System.out::println);
        userList.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
    }

    private List<User> createArrayList() {
        List<Integer> hundred = IntStream.range(0,10)
                .boxed()
                .collect(Collectors.toList());
        List<User> userList = new ArrayList<>();
        hundred.forEach((s)->{
            userList.add(new User(s));
        });
        return userList;
    }

}

