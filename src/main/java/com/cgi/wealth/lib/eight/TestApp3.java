package com.cgi.wealth.lib.eight;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestApp3 {
    public static void main(String[] args) {
        extracted();

        List<Integer> iList = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        for (int i = 0; i < iList.size(); i++) {

            for(int j=iList.size(); j>=0; j--){
                System.out.println(i+"-"+j);
            }
        }
    }

    private static void extracted() {
        String usrName = null;
        if(Optional.ofNullable(usrName).isPresent()){
            System.out.println("Username is present");
        } else {
            System.out.println("Username is not present");
        }
    }
}

