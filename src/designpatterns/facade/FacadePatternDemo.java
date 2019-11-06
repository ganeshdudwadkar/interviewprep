package designpatterns.facade;

/*
Facade pattern hides the complexities of the system and provides an interface to the client using which the client
can access the system. This type of design pattern comes under structural pattern as this pattern adds an interface
to existing system to hide its complexities.

Step 1 - Create an interface - Shape.java
Step 2 - Create concrete classes implementing the same interface - Rectangle, Circle, Square
Step 3 - Create a facade class - ShapeMaker.java
Step 4 - Use the facade to draw various types of shapes.
 */

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
