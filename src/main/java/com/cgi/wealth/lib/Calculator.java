package com.cgi.wealth.lib;

interface Calculator {
    default void onInt(){
        System.out.println("Calculator on Int, clear previous Calculation");
    }

    boolean isEqual(String a, String b);

    String add(String a, String b);

    Integer add(Integer a, Integer b);

    int zeroDividedBy(int a);

    int incrementByOne(int a);
}
