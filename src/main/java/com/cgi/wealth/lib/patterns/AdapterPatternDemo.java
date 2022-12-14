package com.cgi.wealth.lib.patterns;

import java.util.List;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        var shapePrinter = new ShapePrinter();
        shapePrinter.print("letter", "75th year of independence");
        shapePrinter.print("a4", "75th year of independence");

    }
}

class ShapePrinter implements Shape {

    Square square;

    @Override
    public void draw() {

    }

    @Override
    public int calculateArea(Integer[] arr) {
        return 0;
    }

    @Override
    public void print(String printType, String printContent) {
        List<Integer> l = List.of(1,2,3,4);

        l.forEach(i -> System.out.println(i*i));

        if(printType.equalsIgnoreCase("letter")){
            System.out.println("Letter Print completed!");
        } else {
            var printer = new Square(printType);
            printer.print(printType, printContent);
        }
    }
}

class A4Printer implements Printer {

    @Override
    public void A4Print(String printContent) {
        System.out.println("A4 Print completed!");
    }

    @Override
    public void CardPrint(String printContent) {
        System.out.println("This is A4 printer. No action taken");
    }
}

class CardPrinter implements Printer {
    @Override
    public void A4Print(String printContent) {
        System.out.println("This is Card printer. No action taken");
    }

    @Override
    public void CardPrint(String printContent) {
        System.out.println("Card Print completed!");
    }
}