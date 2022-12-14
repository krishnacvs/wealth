package com.cgi.wealth.lib.seven.generics;

import lombok.Data;

public class App {
    public static void main(String[] args) {
        App app = new App();
        GenericInterface genericClass = new GenericStringClass();
        ((GenericStringClass<?>) genericClass).setA("A");
        ((GenericStringClass<?>) genericClass).setB("B");
        genericClass.append();

        genericClass = new GenericIntegerClass();
        ((GenericIntegerClass<?>) genericClass).setA(1);
        ((GenericIntegerClass<?>) genericClass).setB(2);
        genericClass.append();
    }
}


interface GenericInterface<T>{
    void append();
}

@Data
class GenericStringClass<T> implements GenericInterface<T> {
    private String a;
    private String b;

    @Override
    public void append() {
        System.out.println(a+b);
    }
}

@Data
class GenericIntegerClass<T> implements GenericInterface<T> {
    private int a;
    private int b;

    @Override
    public void append() {
        System.out.println(a+b);
    }
}
