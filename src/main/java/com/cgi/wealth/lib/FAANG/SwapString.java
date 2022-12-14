package com.cgi.wealth.lib.FAANG;

import org.junit.Test;

import java.util.Arrays;

public class SwapString {
    public static void main(String[] args) {
        //extracted("rotator");

        //extracted1("meter");

        System.out.println(extracted2("meter"));
    }

    private static String extracted2(String in) {
        return new StringBuilder(in).reverse().toString();
    }

    private static void extracted1(String in) {
        char[] charArr = in.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = charArr.length-1; i >= 0; i--) {
            sb.append(charArr[i]);
        }
        System.out.println(sb.toString());
    }

    private static void extracted(String rotator) {
        char[] charArr = rotator.toCharArray();
        System.out.println(Arrays.toString(charArr));
        char tmp;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr.length; j++) {
                if (j > i) {
                    //System.out.println(i+"-"+j);
                    tmp = charArr[i];
                    charArr[i] = charArr[j];
                    charArr[j] = tmp;
                    System.out.println(Arrays.toString(charArr));
                }
            }

        }
    }

    String removeWhiteSpaces(String input){
        StringBuilder output = new StringBuilder();

        char[] charArray = input.toCharArray();

        for(char c : charArray) {
            if (!Character.isWhitespace(c))
                output.append(c);
        }

        return output.toString();
    }

    @Test
    private void swapVars(){
        int a = 25;
        int b = 69;
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a+":"+b);
    }

    @Test
    private void swapChars(){
        String name = "Venkata Sri Krishna";
        String replace = "a";
        String with = "ha";
        String newName = name.replaceAll("a",with);
        System.out.println(newName);
    }
}
