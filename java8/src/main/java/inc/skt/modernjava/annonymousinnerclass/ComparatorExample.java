package inc.skt.modernjava.annonymousinnerclass;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        // Comparator with Anonymous Inner Class
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Comparing 2 with 3 using Anonymous Inner class " + comparator1.compare(2,3));

        // Comparator with Java 8 Lambda expression
        Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println("Comparing 2 with 3 using Java 8 Lambda expression "+ comparator2.compare(2,3));
    }
}
