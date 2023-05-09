package inc.skt.modernjava.streams;

class A {
    A() {
        System.out.println("Constructor A");
    }
}

class B extends A {
    B() {
        System.out.println("Constructor B");
    }
}
public class App {
    public static void main(String[] args) {
        A a = new B();
    }
}
