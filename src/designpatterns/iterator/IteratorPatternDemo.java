package designpatterns.iterator;

/*

Iterator Pattern is very commonly used design pattern in Java and .Net programming environment.
This pattern is used to get a way to access the elements of a collection object in sequential manner without any need
to know its underlying representation.
Step 1 - Create interfaces - Iterator.java and Container.java
Step 2 - Create concrete class implementing the Container interface. This class has inner class NameIterator implementing the Iterator interface.
Step 3 - Use the NameRepository to get iterator and print names.

 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}

/*
Output -

Name : Robert
Name : John
Name : Julie
Name : Lora
 */
