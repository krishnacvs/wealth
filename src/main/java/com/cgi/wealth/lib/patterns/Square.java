package com.cgi.wealth.lib.patterns;

public class Square extends CloneShape implements Shape {

    Printer printer;

    public Square(String printType){
        if(printType.equalsIgnoreCase("a4")){
            printer = new A4Printer();
        }
        if(printType.equalsIgnoreCase("card")){
            printer = new CardPrinter();
        }
    }

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Draw square");
    }

    @Override
    public int calculateArea(Integer[] arr) {
        return arr[0]*arr[0];
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
