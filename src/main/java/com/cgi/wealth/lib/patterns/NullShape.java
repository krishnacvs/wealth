package com.cgi.wealth.lib.patterns;

public class NullShape extends CloneShape implements Shape {

    Printer printer;

    public NullShape(String printType){
        if(printType.equalsIgnoreCase("a4")){
            printer = new A4Printer();
        }
        if(printType.equalsIgnoreCase("card")){
            printer = new CardPrinter();
        }
    }

    public NullShape(){
        type = "NullShape";
    }
    @Override
    public void draw() {
        System.out.println("Draw NullShape");
    }

    @Override
    public int calculateArea(Integer[] arr) {
        return 0;
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
