package com.cgi.wealth.lib.patterns;


public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape red
                = new RedShapeDecorator(circle);
        red.draw();

        red
                = new RedShapeDecorator(new Triangle());
        red.draw();
    }
}

class ShapeDecorator implements Shape {

    Shape decoratedShape;

    ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }

    @Override
    public int calculateArea(Integer[] arr) {
        return 0;
    }

    @Override
    public void print(String printType, String printContent) {

    }

    private void setBlueBorder(Shape decoratedShape) {
        System.out.println("Border Color: Blue");
    }


}


class RedShapeDecorator extends ShapeDecorator  {

    Shape decoratedShape;

    RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    @Override
    public int calculateArea(Integer[] arr) {
        return 0;
    }

    @Override
    public void print(String printType, String printContent) {

    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }

}