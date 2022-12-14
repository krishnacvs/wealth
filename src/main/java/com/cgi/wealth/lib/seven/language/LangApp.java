package com.cgi.wealth.lib.seven.language;

import java.lang.System;

/**
 * All the classes in the package are imported by default
 *
 */
public class LangApp {
    public static void main(String[] args) {
        System.out.println("java.lang.System"); //java.lang.System
        String[] langClasses = new String[] {
                "Object",// Base class for every class
                "String",
                "Wrapper classes",
                "Math",
                "System",
                "StringBuffer", // It is threadSafe
                "StringBuilder", // not threadSafe
                "Thread",
                "Throwable"
        };

        printObjectClass();
    }

    private static void printObjectClass() {
        Object o1 = new Object();
        System.out.println(o1.hashCode());
        System.out.println(o1.toString());
        Object o2 = new Object();
        System.out.println(o2.hashCode());
        System.out.println("o1 is equal to o2 "+o1.equals(o2));
    }
}
