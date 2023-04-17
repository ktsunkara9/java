package inc.skt.modernjava.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate1= (i) -> i%2 ==0;
        System.out.println(predicate1.test(6));

        // negate() method can reverse the result
        System.out.println(predicate1.negate().test(2));

        Predicate<Integer> predicate2 = i -> i%5 ==0;
        System.out.println(predicate2.test(5));

        System.out.println(predicate1.and(predicate2).test(10));
        System.out.println(predicate1.and(predicate2).test(8));

        System.out.println(predicate1.or(predicate2).test(8));

    }
}
