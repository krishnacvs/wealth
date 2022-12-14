package com.cgi.wealth.lib.patterns;

class Context {
    private Shape shape;

    public Context(Shape shape){
        this.shape = shape;
    }

    public int calculateArea(Integer[] arr){
        return shape.calculateArea(arr);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        var calculatedArea = 0;
        Context context = new Context(new Square());
        Integer[] arr = new Integer[]{10};
        calculatedArea = context.calculateArea(arr);
        System.out.println("Calculated area "+calculatedArea);
        Context context1 = new Context(new Triangle());
        arr = new Integer[]{10, 20};
        calculatedArea = context1.calculateArea(arr);
        System.out.println("Calculated area "+calculatedArea);
        Context context2 = new Context(new NullShape());
        arr = new Integer[]{10, 20};
        calculatedArea = context2.calculateArea(arr);
        Context context3 = new Context(new Circle());
        arr = new Integer[]{10, 20};
        calculatedArea = context3.calculateArea(arr);
        System.out.println("Calculated area "+calculatedArea);
    }
}
