package com.cgi.wealth.lib.patterns;

import java.util.Random;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyCirlceAccess proxyCirlceAccess = new ProxyCirlceAccess("john snow");
        proxyCirlceAccess.print("a4", "75th year of independence");
    }
}


class ProxyCirlceAccess implements Shape {

    private String user;
    private Circle circle;

    ProxyCirlceAccess(String user) {
        this.user = user;
    }

    @Override
    public void draw() {

    }

    @Override
    public int calculateArea(Integer[] arr) {
        var calculateArea = 0;
        if (getRole(user) > 3) {
            circle = new Circle("a4");
            calculateArea = circle.calculateArea(arr);
        }
        return calculateArea;
    }


    @Override
    public void print(String printType, String printContent) {
        if (getRole(user) > 3) {
            circle = new Circle("a4");
            circle.print(printType, printContent);
        } else {
            System.out.println("Proxy no access to print");
        }
    }

    private int getRole(String user) {
        return new Random().ints(1, 0, 10).boxed().findFirst().orElse(5);
    }
}