package com.cgi.wealth.lib.patterns;

public interface Shape {
    void draw();
    int calculateArea(Integer[] arr);

    default <T> T[] toArray(T... arguments) {
        return arguments;
    }

    void print(String printType, String printContent);
}
