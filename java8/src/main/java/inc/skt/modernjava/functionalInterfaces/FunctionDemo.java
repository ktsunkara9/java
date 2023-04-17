package inc.skt.modernjava.functionalInterfaces;

import java.util.function.Function;

public class FunctionDemo {
    static Function<String, String> toUpperCase = (s1) -> s1.toUpperCase();

    static Function<String, String> concat = (s1) -> s1.concat(" Tutorial");
    public static void main(String[] args) {
        System.out.println(toUpperCase.apply("java8"));
        System.out.println(toUpperCase.andThen(concat).apply("java8"));
        System.out.println(toUpperCase.compose(concat).apply("java8"));
    }
}
