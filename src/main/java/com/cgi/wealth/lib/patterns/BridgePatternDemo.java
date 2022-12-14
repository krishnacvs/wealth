package com.cgi.wealth.lib.patterns;

public class BridgePatternDemo {
    public static void main(String[] args) {
        CloneAbstract bridge = new CloneAbstract(new Circle(), new Triangle());
        bridge.shapeMaker();
    }
}


abstract class ShapeAbstract {

    Shape circle;
    Shape triangle;

    ShapeAbstract(Shape circle, Shape triangle) {
        this.circle = circle;
        this.triangle = triangle;
    }

    abstract public void shapeMaker();
}

class CloneAbstract extends ShapeAbstract {

    CloneAbstract(Shape circle, Shape triangle) {
        super(circle, triangle);
    }

    @Override
    public void shapeMaker() {
        System.out.println("CircleAbstract");
        circle.draw();
        triangle.draw();
    }
}

