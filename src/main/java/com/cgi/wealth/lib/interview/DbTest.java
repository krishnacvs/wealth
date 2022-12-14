package com.cgi.wealth.lib.interview;

import java.util.*;
import java.util.stream.Collectors;

public class DbTest {
    public static void main(String[] args) {
        int[] iList = new int[] {10, 20, 30, 40, 50, 50, 60, 10};
        int tmp;
        for (int i = 0; i < iList.length; i++) {
            System.out.println("i "+i);
            tmp = iList[i];

        }
    }

    private static void extracted1() {
        List<Integer> iList = Arrays.asList(new Integer[] {10, 20, 30, 40, 50, 50, 60, 10});
        var a = iList.stream().max(Integer::compareTo);
        System.out.println(a);
    }

    private static void extracted() {
        List<Integer> iList = Arrays.asList(new Integer[] {10, 20, 30, 40, 50, 50, 60, 10});
        Set<Integer> iSet = new LinkedHashSet<>(iList);
        System.out.println(iSet);
    }

}
