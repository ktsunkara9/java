package inc.skt.modernjava.functionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    static UnaryOperator<String> unaryOperator = s -> s.concat(" Tutorial");
    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("Angular"));
    }
}
