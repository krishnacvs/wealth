package com.cgi.wealth.lib.FAANG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeleteElement {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        iList = IntStream.range(0,10).boxed().collect(Collectors.toList());
        int index = 5;
        for (int i = 0; i < iList.size(); i++) {
            if(i ==index){
                iList.remove(i);
            }
        }
        System.out.println(iList);
    }
}
