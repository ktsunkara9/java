package inc.skt.modernjava.defaultstatic;

public class MultipleInheritanceDemo {
    public static void main(String[] args) {

    }
}

class Impl implements Interface1, Interface2 {
    @Override
    public void methodA() {
        System.out.println("overrided method");
        //Interface1.super.methodA();
    }
}

interface Interface1 {
    default void methodA() {
        System.out.println("method A");
    }
}


interface Interface2 {
    default void methodA() {
        System.out.println("method A");
    }
}

