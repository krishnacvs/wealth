package com.cgi.wealth.lib.patterns;

public class Triangle extends CloneShape implements Shape {

    Printer printer;

    public Triangle(String printType){
        if(printType.equalsIgnoreCase("a4")){
            printer = new A4Printer();
        }
        if(printType.equalsIgnoreCase("card")){
            printer = new CardPrinter();
        }
    }

    public Triangle(){
        type = "Triangle";
    }
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }

    @Override
    public int calculateArea(Integer[] arr) {
        return (arr[0]*arr[1])/2;
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
