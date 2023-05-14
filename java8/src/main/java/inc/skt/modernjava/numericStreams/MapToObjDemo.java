package inc.skt.modernjava.numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapToObjDemo {

    public static void main(String[] args) {
        List<Integer> intList = IntStream.rangeClosed(1,5).mapToObj( i -> new Integer(i)).collect(Collectors.toList());
        System.out.println(intList);

        List<Long> longList = IntStream.rangeClosed(1,5)
                .mapToLong(i -> i)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longList);

        List<Double> doubleList = IntStream.rangeClosed(1,5)
                .mapToDouble(i -> i)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(doubleList);

        Long longSum = IntStream.rangeClosed(1,10).mapToLong(i -> i).sum();
        System.out.println("longSum "+longSum);

        Double doubleSum = IntStream.rangeClosed(1, 10).mapToDouble(i -> i).sum();
        System.out.println("doubleSum "+doubleSum);
    }
}
