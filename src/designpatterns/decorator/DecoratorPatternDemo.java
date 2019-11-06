package designpatterns.decorator;
/*
Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.

This pattern creates a decorator class which wraps the original class and provides additional functionality keeping
class methods signature intact.

Step 1 - Create an interface - Shape.java
Step 2 - Create concrete classes implementing the same interface - Circle.java, Rectangle.java
Step 3 - Create abstract decorator class implementing the Shape interface - ShapeDecorator.java
Step 4 - Create concrete decorator class extending the ShapeDecorator class - RedShapeDecorator.java
Step 5 - Use the RedShapeDecorator to decorate Shape objects
 */

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
