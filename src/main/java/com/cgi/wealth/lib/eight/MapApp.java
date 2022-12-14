package com.cgi.wealth.lib.eight;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MapApp {
    public static void main(String[] args) {
        Map<Integer, Integer> intMap = new LinkedHashMap<>();
        IntStream
                .range(0,10)
                .forEach(i->intMap.put(i,i));

        lambdaForEach(intMap);
        iterateByEntrySet(intMap);
        iterateByKeySet(intMap);
    }

    private static void lambdaForEach(Map<Integer, Integer> intMap) {
        intMap.forEach((k,v)-> System.out.println(k+"-"+v));
    }

    private static void iterateByEntrySet(Map<Integer, Integer> intMap){
        for(Map.Entry<Integer,Integer> entry: intMap.entrySet()){
            System.out.println("Entry "+entry.getKey() + ":" + entry.getValue());
        }
    }

    private static void iterateByKeySet(Map<Integer, Integer> intMap){
        for(Integer key : intMap.keySet()){
            System.out.println("Key "+key + ":" + intMap.get(key));
        }
    }

}
