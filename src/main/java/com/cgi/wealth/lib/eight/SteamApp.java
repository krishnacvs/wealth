package com.cgi.wealth.lib.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SteamApp {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        IntStream
                .range(0,10)
                .forEach(r -> iList.add(r));

        Predicate<Integer> p = e -> e % 2 ==0;
        List<Integer> eList = iList
                .stream()
                .filter(l -> p.test(l))
                .collect(Collectors.toList());

        System.out.println(eList);

        BiPredicate<Integer, Integer> b = (e1,e2)-> e1 > e2;

        System.out.println(b.test(1, 2));

        Optional<Integer> bList = iList.stream().peek(System.out::println)
                .reduce((l1, l2) -> b.test(l2, l1) ? l2 : l1);
        if(bList.isPresent()){
            System.out.println("bList is present");
            System.out.println(bList.get());
        } else {
            System.out.println("bList is empty");
        }
    }
}
