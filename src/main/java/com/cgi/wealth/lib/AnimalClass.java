package com.cgi.wealth.lib;

interface Age {
    int x = 21; // int is primitive datatype Integer is wrapper class. These are 8 types. Useful in Collections framework
    void getAge();

    void resetAge();
}

public class AnimalClass {

    public static void main(String[] args) {
        System.out.println("I am here");
        Age oj1 = new Age() { // this an anonymous class, created out of the interface without a name

            @Override
            public void getAge() {
                System.out.print("Age is " + x);
            }

            @Override
            public void resetAge() {
                System.out.print("Age is " + 0);
            }
        };
        oj1.getAge();
    }
}
