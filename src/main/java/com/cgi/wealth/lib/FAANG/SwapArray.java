package com.cgi.wealth.lib.FAANG;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SwapArray {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(intArr));
        int tmp;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length; j++) {
                if (j > i) {
                    //System.out.println(i+"-"+j);
                    tmp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = tmp;
                    System.out.println(Arrays.toString(intArr));
                }
            }

        }
    }

    @Test
    private void commonArrayElements(){
        int[] array1 = new int[]{1,4,7,9,2};
        int[] array2 = new int[]{1,7,3,4,5};
        int[] commonArray = new int[array1.length+array2.length];
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                System.out.println(array1[i]+" "+array2[j]);
                if(array1[i] == array2[j]){
                    commonArray[count] = array1[i];
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(commonArray));
    }

    @Test
    private void commonArrayElements8(){
        int[] array1 = new int[]{1,4,7,9,2};
        int[] array2 = new int[]{1,7,3,4,5};
        int[] commonArray = new int[array1.length+array2.length];
        AtomicInteger count = new AtomicInteger(0);
        Arrays.stream(array1).boxed().forEach((s1)-> {
            Arrays.stream(array2).boxed().forEach(s2 ->{

                if(s1 == s2){
                    System.out.println(s1+" "+s2);
                    commonArray[count.getAndIncrement()]=s1;
                }
            });
        });
        System.out.println(Arrays.toString(commonArray));
    }
}
