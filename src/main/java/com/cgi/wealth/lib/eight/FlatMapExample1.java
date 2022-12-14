package com.cgi.wealth.lib.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Stream<String[]>      -> flatMap ->	Stream<String>
 * Stream<Set<String>>   -> flatMap ->	Stream<String>
 * Stream<List<String>>  -> flatMap ->	Stream<String>
 * Stream<List<Object>>  -> flatMap ->	Stream<Object>
 */

public class FlatMapExample1 {

    public static void main(String[] args) {

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/

        List<String> collect =
                list.stream()
                        .map(x -> x.getBook())                              //  Stream<Set<String>>
                        .flatMap(x -> x.stream())                           //  Stream<String>
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                        .collect(Collectors.toList());                       //  remove duplicated

        //collect.forEach(System.out::println);


                list.stream()
                        .map(x -> x.getBook())
                        .forEach(x-> System.out.println(x));

    }

}