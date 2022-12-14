package com.cgi.wealth.lib.seven.language;

/**
 * String is not a wrapper class
 * Strings are immutable
 * Strings are stored in string constant pool
 * Strings are by default final
 * Strings are thread safe
 * If  declare a class as final and its attributes as final, it will become immutable
 * It is recommended to store password in char array than using strings
 */

public class StringApp {

    public static void main(String[] args) {
        String s1 = "John";
        String s2 = "John"; // will point to same object

        String s3 = "New"; // stores in Pool
        String s4 = new String("New"); // stores in heap

        char[] arr = new char[]{'c', 'v', 's'};
        String objectStr = new String(arr);

        objectStr.intern(); // moves to String Pool

        Integer int1 = Integer.valueOf(1);

        /**
         * Concat - not recommended
         * StringBuilder - Most recommended, high performance
         * StringBuffer - Thread safe used in multi thread
         */
        String ss1 = "Basic";

        String ss2 = new StringBuilder("Basic").toString();

        System.out.println("Is ss1 equal to ss2 " + ss1.equals(ss2));
        String ss3 = new StringBuffer("Basic").toString();
        System.out.println("Is ss1 equal to ss3 " + ss1.equals(ss3));

        String ts1 = "Java"; // "Java" String created in pool and reference assigned to s1

        String ts2 = ts1; //s2 is also having the same reference to "Java" in the pool

        System.out.println(ts1 == ts2); // proof that s1 and s2 have same reference

        ts1 = "Python";
        //s1 value got changed above, so how String is immutable?

        //well, in the above case a new String "Python" got created in the pool
        //s1 is now referring to the new String in the pool
        //BUT, the original String "Java" is still unchanged and remains in the pool
        //s2 is still referring to the original String "Java" in the pool

        // proof that s1 and s2 have different reference
        System.out.println(ts1 == ts2);

        System.out.println(ts2);
        // prints "Java" supporting the fact that original String value is unchanged, hence String is immutable
    }
}
