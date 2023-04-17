package inc.skt.modernjava.functionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (s1,s2) -> System.out.println(s1+","+s2);
        biConsumer.accept("Krishna", "Teja");

        BiConsumer<Integer, Integer> multiply = (a,b) -> System.out.println("multiplication is "+a*b);
        BiConsumer<Integer, Integer> division = (a,b) -> System.out.println("division is "+a/b);

        multiply.andThen(division).accept(10,2);
    }
}
