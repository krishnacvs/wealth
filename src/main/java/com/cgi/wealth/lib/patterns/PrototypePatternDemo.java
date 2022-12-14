package com.cgi.wealth.lib.patterns;

import java.util.HashMap;

public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        CloneShape clonedShape1 = (CloneShape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape1.getType());

        CloneShape clonedShape2 = (CloneShape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
    }

}

class ShapeCache {
    private static HashMap shapeMap = new HashMap();

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Triangle rectangle = new Triangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }

    public static CloneShape getShape(String shapeId) {
        CloneShape shape = (CloneShape) shapeMap.get(shapeId);
        return (CloneShape) shape.clone();
    }
}