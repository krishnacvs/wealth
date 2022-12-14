package com.cgi.wealth.lib.FAANG;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class FindDuplicate {
    public static void main(String[] args) {
        extracted();
    }

    @Test
    public void extracted1() {
        List<Integer> iList = Arrays.asList(new Integer[]{1,2,3,4});
        Integer sumofInts = iList.stream().mapToInt(Integer::intValue).sum();
        sumofInts = iList.stream().reduce(0,(a,b)->a+b);
        sumofInts = iList.stream().reduce(0,Integer::sum);
        sumofInts = iList.stream().collect(summingInt(Integer::intValue));
        System.out.println(sumofInts);

        int[] intArray = new int[] {1,3,4,2,2};
        Map<Integer, Long> mapCount = Arrays.stream(intArray).boxed().collect(groupingBy(i -> i,Collectors.counting()));
        System.out.println(mapCount);

        sumofInts = Arrays.stream(intArray).boxed().collect(summingInt(Integer::intValue));
        System.out.println(sumofInts);

        mapCount = Arrays.stream(intArray).boxed().collect(groupingBy(Integer::intValue,Collectors.counting()));
        System.out.println(mapCount);

        List<Integer> mapCount2 = Arrays.stream(intArray).boxed().peek(System.out::println).collect(Collectors.toList());
        System.out.println(mapCount);

        Map<Integer, Integer> mapCount1 = Arrays.stream(intArray).boxed().collect(groupingBy(Integer::intValue, summingInt(Integer::intValue)));
        System.out.println(mapCount1);
    }

    private static void extracted() {
        int[] intArray = new int[] {1,3,4,2,2};
        List<Integer> uniques = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            if (!uniques.contains(intArray[i])) {
                uniques.add(intArray[i]);
            } else {
                duplicates.add(intArray[i]);
            }
        }
        System.out.println(duplicates);
    }

    @Test
    public void extracted2() {
        List<Integer> iList = Arrays.asList(new Integer[]{1, 2, 3, 4,4,4});
        List<Integer> dlist = iList.stream().filter(i -> Collections.frequency(iList, i) > 1).collect(Collectors.toList());
        System.out.println(dlist);
    }
}
