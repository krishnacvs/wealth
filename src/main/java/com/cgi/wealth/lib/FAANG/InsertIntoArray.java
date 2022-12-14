package com.cgi.wealth.lib.FAANG;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

/**
 How to Insert an element at a specific position in an Array ?
 Given an array of integers arr , an index pos and a value x.
 Insert the value x in the particular index and right shift rest of elements

 Example 1:
 arr = [2, 3, 4, 5, 6]
 pos = 3
 x = 9
 Output: [2, 3, 9, 4, 5, 6]

 5
 2
 3
 4
 5
 6
 3
 9

 */
public class InsertIntoArray {
    public static void main(String args[] ) throws Exception {
        InsertIntoArray s = new InsertIntoArray();
        int arr[] = new int[] {2, 3, 4, 5, 6};
        int pos = 3;
        int x = 9;
        System.out.println(Arrays.toString(s.insertX(arr, pos, x)));
    }

    public int[] insertX(int[] arr, int pos, int x) {
        int i;
        int n = arr.length;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n + 1; i++) {
            if (i < pos - 1)
                newarr[i] = arr[i];
            else if (i == pos - 1)
                newarr[i] = x;
            else
                newarr[i] = arr[i - 1];
        }
        return newarr;
    }
}