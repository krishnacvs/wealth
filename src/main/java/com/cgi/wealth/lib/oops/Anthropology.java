package com.cgi.wealth.lib.oops;

public interface Anthropology {

    static void staticStudy(){
        System.out.println("Do study of Static methods");
    }

    default void defaultStudy(){
        System.out.println("Do study of default methods");
        privateStudy();
    }

    default void secondDefaultStudy(){
        System.out.println("Do study of default methods");
        privateStudy();
    }

    private void privateStudy(){
        System.out.println("Do study of private methods");
    }
}
