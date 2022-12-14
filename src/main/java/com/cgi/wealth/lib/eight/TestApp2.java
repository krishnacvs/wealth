package com.cgi.wealth.lib.eight;

public class TestApp2 {

    public static void main(String[] args) {
        String x = "abc";
        String y = new String("abc");
        if (x == y) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        var x1 = "Hello World";
        var z = " Hello World".trim();
        System.out.println(x1 == z); // False

        System.out.println("c" + null);      // cnull

        String joinString1=String.join("-","Welcome","to","EazyBytes");
        System.out.println(joinString1);




    }
}
