package com.cgi.wealth.lib.eight;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestApp {

    public static void main(String[] args) {
        List<Integer> iList = Arrays.asList(new Integer[]{1,2,3,4});
        Map<Boolean, List<Integer>> partitions = iList
                .stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        List<Integer> evenNums = partitions.get(true);
        System.out.println("evenNums"+evenNums);
        List<Integer> oddNums = partitions.get(false);
        System.out.println("oddNums"+oddNums);

        Map<Integer, Integer> groupBy = iList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(Integer::intValue)));

        System.out.println("group by "+groupBy);

        var sum = iList
                .stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("sum "+sum);

        sum = iList
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("sum "+sum);

        String x = new StringBuffer("Hello").toString();

        String y = new StringBuffer("Hello").toString();

        System.out.println(x==y);


    }

    @Test
    public void filterEvenNumbers(){
        List<Integer> iList = Arrays.asList(new Integer[]{1,2,3,4});
        Map<Boolean, List<Integer>> partitions = iList
                .stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(partitions.get(true));
    }

}
