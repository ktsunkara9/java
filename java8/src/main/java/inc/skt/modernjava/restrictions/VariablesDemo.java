package inc.skt.modernjava.restrictions;

import java.util.function.Consumer;

public class VariablesDemo {

    static int x = 4;
    public static void main(String[] args) {
        int z = 5;

        // you are not allowed to use a local variable name as lambda parameter or for a variable inside the lambda body
        // you are not allowed to re-assign a value to a local variable
        int finalZ = z;
        Consumer<Integer> c1 = (a) -> { // cant use z as the name of the lambda parameter we get a compilation error
            // z = z + 5;  // throws a compilation error
            // a = a + z; // // throws a compilation error we need to use an effectively final variable to do this
            a = a + finalZ;
            System.out.println(a);
        };
        c1.accept(3);

//        Once a local variable is used by a lambda expression its value can not be changed even outside of the lambda expression.
//        So the variable becomes final or effectively final if its being used in a lambda expression.
        z = z+ 3;
        System.out.println("z:"+z);

        // these restrictions are not applied to global variables
        // We can use the same name as of the global variable to a parameter
        Consumer<Integer> c2 = (x) -> System.out.println(x);
        c2.accept(4);
        // We can change the value of the global variable
        Consumer<Integer> c3 = (y) -> {
            x= x + y;
            System.out.println(x);
        };
        c3.accept(5);
        System.out.println(x);
    }
}
