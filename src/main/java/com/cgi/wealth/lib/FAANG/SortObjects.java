package com.cgi.wealth.lib.FAANG;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortObjects {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2};
        Arrays.sort(intArr,Collections.reverseOrder());
        System.out.println(Arrays.toString(intArr));
        List<Integer> intArrList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,-1,-2});
        Collections.sort(intArrList,Collections.reverseOrder());
        System.out.println(intArrList);
    }
}
