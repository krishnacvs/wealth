package com.cgi.wealth.lib.eight;

import java.util.StringJoiner;

public class StringApp {
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    public static void main(String[] args) {
        testStringJoiner();
    }

    private static void testStringJoiner() {
        StringJoiner joiner =  new StringJoiner(",", PREFIX, SUFFIX);
        System.out.println(joiner.toString());
        joiner.add("Red")
                .add("Green")
                .add("Blue");
        System.out.println(joiner.toString());
    }
}
