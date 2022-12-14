package com.cgi.wealth.lib.oops;

/**
 * These are called pure abstract classes till 1.7
 * 1.8
 * static and default
 *
 * 1.9
 * private methods
 *
 * Can implement multiple inheritance
 *
 */
public interface Sociology {
    public void doHumanStudy();

    static void staticStudy(){
        System.out.println("Do study of Static methods");
    }

    static void staticStudy(boolean doItNow){
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
