package com.cgi.wealth.lib.patterns;

public class Circle extends CloneShape implements Shape {

    Printer printer;

    public Circle(String printType){
        if(printType.equalsIgnoreCase("a4")){
            printer = new A4Printer();
        }
        if(printType.equalsIgnoreCase("card")){
            printer = new CardPrinter();
        }
    }
    public Circle(){
        type = "Circle";
    }
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }

    @Override
    public int calculateArea(Integer[] arr) {
        var area = Math.PI * arr[0] * arr[0];
        return (int) area;
    }

    @Override
    public void print(String printType, String printContent) {
        if(printType.equalsIgnoreCase("a4")){
            printer.A4Print(printContent);
        }
        if(printType.equalsIgnoreCase("card")){
            printer.CardPrint(printContent);
        }
    }
}
