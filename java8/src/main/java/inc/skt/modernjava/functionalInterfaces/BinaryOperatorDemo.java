package inc.skt.modernjava.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    static BinaryOperator<Integer> binaryOperator = (a,b) -> a * b;
    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
    public static void main(String[] args) {
        System.out.println(binaryOperator.apply(3,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println(minBy.apply(9 ,3));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println(maxBy.apply(9 ,3));
    }
}
