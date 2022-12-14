package com.cgi.wealth.lib.eight;

interface HasTail {
    private int getTailLength() {
        return 10_0;
    }
}

abstract class Puma implements HasTail {
    String getTailLength() {
        return "4";
    }
}


public class Cougar implements HasTail {


    public static void main(String[] args) {
        var puma = new Puma() {
        };
        System.out.println(puma.getTailLength());
    }


    public int getTailLength(int length) {
        return 2;
    }
}