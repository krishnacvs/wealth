package com.cgi.wealth.lib.seven.collections;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class MapApp {

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAndAddOnHashMap_thenConcurrentModificationError() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
        Iterator<Map.Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            synchronizedMap.put(3, "Modification");
            iterator.next();
        }
    }

    @Test
    public void iterateByEntrySet(){
        Map<Integer, Integer> zeroMap = new ConcurrentHashMap<>();
        IntStream
                .range(0,10)
                .forEach(i->zeroMap.put(i,i));
        Iterator<Map.Entry<Integer, Integer>> iterator = zeroMap.entrySet().iterator();
        while (iterator.hasNext()) {
            zeroMap.put(11, 11);
            iterator.next();
        }
        System.out.println(zeroMap);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterateList(){
        List<Integer> zeroList = new ArrayList<>();
        IntStream
                .range(0,10)
                .forEach(i->zeroList.add(i));
        Iterator<Integer> iterator = zeroList.iterator();
        while (iterator.hasNext()) {
            zeroList.add(11);
            iterator.next();
        }
        System.out.println(zeroList);
    }

    @Test
    public void iterateCopyOnWriteArrayList(){
        CopyOnWriteArrayList<Integer> zeroList = new CopyOnWriteArrayList<>();
        IntStream
                .range(0,10)
                .forEach(i->zeroList.add(i));
        Iterator<Integer> iterator = zeroList.iterator();
        while (iterator.hasNext()) {
            zeroList.add(11);
            iterator.next();
        }
        System.out.println(zeroList);
    }
}
