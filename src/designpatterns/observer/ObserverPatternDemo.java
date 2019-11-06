package designpatterns.observer;

/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.

Step 1 - Create Subject class.
Step 2 - Create Observer class.
Step 3 - Create concrete observer classes
Step 4 - Use Subject and concrete observer objects

 */

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

/*
Output -

First state change: 15
Hex String: F
Octal String: 17
Binary String: 1111
Second state change: 10
Hex String: A
Octal String: 12
Binary String: 1010

 */