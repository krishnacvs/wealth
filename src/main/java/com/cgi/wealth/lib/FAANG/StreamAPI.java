package com.cgi.wealth.lib.FAANG;

import java.util.*;

public class StreamAPI {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        List<Integer> iList = new ArrayList<>();
        for(int i=0; i<length; i++ ) {
            iList.add(s.nextInt());
        }
        StreamAPI solution = new StreamAPI();
        int returnData = solution.sumOfStream(iList);
        System.out.println(returnData);
    }

    public int sumOfStream(List<Integer> iList){
        return iList.stream().mapToInt(Integer::intValue).sum();
    }
}
