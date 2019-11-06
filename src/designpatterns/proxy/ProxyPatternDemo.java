package designpatterns.proxy;

/*

In proxy pattern, a class represents functionality of another class. This type of design pattern comes under structural pattern.

In proxy pattern, we create object having original object to interface its functionality to outer world.

Step 1 - Create an interface - Image.java
Step 2 - Create concrete classes implementing the same interface - RealImage.java and ProxyImage.java
Step 3 - Use the ProxyImage to get object of RealImage class when required.


 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}

/*
Output :-

Loading test_10mb.jpg
Displaying test_10mb.jpg

Displaying test_10mb.jpg

 */
