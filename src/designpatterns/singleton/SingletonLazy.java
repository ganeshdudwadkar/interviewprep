package designpatterns.singleton;

//Singleton pattern with lazy instantiation
class SingletonLazy {
    private static SingletonLazy obj;

    private SingletonLazy() {
    }

    public static SingletonLazy getSingletonLazy() {
        if (obj == null) {
            synchronized (SingletonLazy.class) {
                if (obj == null) {
                    obj = new SingletonLazy();//instance will be created at request time
                }
            }
        }
        return obj;
    }

    public void doSomething() {
        //write your code
    }
}