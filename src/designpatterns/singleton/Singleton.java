package designpatterns.singleton;

class Singleton {
    private static Singleton obj = new Singleton();//Early, instance will be created at load time

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return obj;
    }

    public void doSomething() {  //so it can be accessed via A.getA.doSimething();
        //write your code
    }
}