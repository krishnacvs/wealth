package com.cgi.wealth.lib.patterns;

class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        Shape factory = null;
        switch (shapeType){
            case "CIRCLE":
                factory =  new Circle();
            case "TRIANGLE":
                factory =  new Triangle();
            case "SQUARE":
                factory =  new Square();
            default:
                factory = new NullShape();
        }
        return factory;
    }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shapeType) ;
}

class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory();
        }
    }
}

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape2.draw();
        //get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        Shape shape3 = shapeFactory1.getShape("CIRCLE");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square
        Shape shape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();

        AbstractFactory shapeFactory2 = FactoryProducer.getFactory(false);
        Shape shape5 = shapeFactory2.getShape("RECTANGLE");
        //call draw method of Shape Square
        shape5.draw();

    }
}