package com.cgi.wealth.lib;

import java.util.List;

public interface  Camera {
    void onInt();

    <T> List<T> genericsList();

    default <T> T[] toArray(T... arguments) {
        return arguments;
    }

    default String WelCome(){
        return "Welcome to Camera";
    }

    static void Click(){
        System.out.println("Clicked");
    }
}
