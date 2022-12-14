package com.cgi.wealth.lib.operations;

public class HealthCare {

    public static void main(String[] args) {
        var a = 1;
        var b = a + 1 -2; //arthematic operators

        var strA = "This is a challenge ";

        var strB = "Challenge accepted";

        System.out.println(strA+strB); // operator overloading

        /**
         * Short operations can't be casted to short
         */
        short a1 = 1;
        short a2 = a1++;
        int b1 = a + 1 -2; //arthematic operators

        /**
         * Unary
         */
        int i1 = 10;
        i1++;
        System.out.println(++i1);
        i1--;
        boolean boo = !true;

        /**
         * Assignment
         */
        i1 =+ 10;
        i1 += 10;

        /**
         * Relational
         */

        System.out.println("Print equals"+(a1==i1));

        Integer integer1 = Integer.valueOf(10);
        System.out.println("integer1 "+integer1);
        Integer integer2 = 10;
        System.out.println("equals "+integer1.equals(integer2));

        /**
         * Ternary operator
         */
        int t = (5 >0)? 5 : 0;

    }


}
