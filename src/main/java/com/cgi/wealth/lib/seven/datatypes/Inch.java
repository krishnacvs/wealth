package com.cgi.wealth.lib.seven.datatypes;

/**
* Identifier is class Demo, String *a*,  int *a*
* Prefer length is 4 to 15
* Identifier start with a digit is not allowed 1a
*
* String final is not valid
*
* 50 key words in Java are reserved
*
* goto is not a reserved keyword
*
* String String is allowed
*
* String null is not allowed
*
* null is not a keyword, it is a literal
* */

public class Inch {
    final String  $abcdefghijklmopqrstuv = "ABC";

    String _1;

    String a1;

    String String;

    int a = 1000000000; //Max is Trilion 32 bit -2^31 to +2^31

    short aa = (short) -1000000000; //Max is Trilion 16 bit -2^16

    long l1 = 10l;

    float f1 = 10.001f; // float consumes lesser memory than double

    double d = 10.01;

    double d1 = f1;

    double d2 = l1; //implicit

    Object o1; //default value is null

    /**
     * It is the entry point of the program from OS
     * After JDK 7 it is mandatory. We can't run the java program without main
     * Main can not be
         * No-static
         * private
         * with return type
     * It can be final
     * @param args
     */
    public final static void main(String[] args) {
        var inch = new Inch();
        int i = 10;
        var a = 1;
        byte b = 2;
        char c = 'A';
        System.out.println(a+b+c);

        Double d2 = inch.d1;
        Float f2 = inch.f1;

        inch.passMethodByValue(i);
        System.out.println("After passMethod "+i);
    }

    private void passMethodByValue(int i) {
        i++;
    }
}
