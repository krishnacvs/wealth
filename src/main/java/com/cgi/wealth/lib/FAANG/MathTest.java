package com.cgi.wealth.lib.FAANG;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MathTest {

    @Test
    public void isPrime(){
        System.out.println("E-Learning Company" + 100 + 100);
        int a = 3;
        int i = 0;
        for (int j = 1; j < a; j++) {
            if(a%j == 0){
                i++;
            }
        }
        if(i > 2){
            System.out.println(a+" is not a prime number");
        } else {
            System.out.println(a+" is prime number");
        }
    }

    @Test
    public void sumOfInt(){
        List iList = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(0);
        iList.forEach(n->{
            sum.addAndGet((Integer) n);
        });
        System.out.println(sum);
    }

    public void intList(){
        List<Integer> iList;
        var num = new Integer[]{1,2,3,4};
        int z = -127000;
        Double v = 10_000_000_0000.0;
    }

    @Test
    public void duplicateItems(){
        var num = new Integer[]{10,15,8,49,25,98,98,32,15,10,8};
        Map<Integer, List<Integer>> numStats = Arrays.stream(num).collect(Collectors.groupingBy(Integer::intValue));
        System.out.println(numStats);
        for(Integer key : numStats.keySet()){
            System.out.println(numStats.get(key).size());
        }
    }

    @Test
    public void duplicateItems1(){
        var num = new Integer[]{10,15,8,49,25,98,98,32,15,10,8};
        var num2 = Arrays.asList(new Integer[]{});
        Arrays.stream(num).forEach(i -> {
            if(!num2.contains(i)){
                num2.add(i);
            }
        });
        System.out.println(num2);
    }

    @Test
    public void ItemStats(){
        var num = Arrays.asList(new Integer[]{10,15,8,49,25,98,98,32,15,10,8});
        IntSummaryStatistics numStats = num.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(numStats.getCount());
    }
}
