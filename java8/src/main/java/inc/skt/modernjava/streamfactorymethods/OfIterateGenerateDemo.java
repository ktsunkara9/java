package inc.skt.modernjava.streamfactorymethods;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OfIterateGenerateDemo {

    public static void main(String[] args) {
        System.out.println("***** of() *****");
        Stream.of("SKT", "HHH", "RKO").forEach(System.out::println);
        System.out.println("***** iterate() *****");
        Stream.iterate(1, x -> x*2).limit(10).forEach(System.out::println);
        System.out.println("***** generate() *****");
        Supplier<Integer> supplier = () -> new Random().nextInt();
        Stream.generate(supplier).limit(5).forEach(System.out::println);
    }
}
