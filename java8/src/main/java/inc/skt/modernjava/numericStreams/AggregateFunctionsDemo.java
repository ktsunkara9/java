package inc.skt.modernjava.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AggregateFunctionsDemo {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 6).sum();
        System.out.println("sum " + sum);

        OptionalInt max = IntStream.range(1, 50).max();
        System.out.println("max " + (max.isPresent() ? max.getAsInt() : 0));

        System.out.println("count " + IntStream.rangeClosed(0, 0).count());

        OptionalLong min = LongStream.range(50,100).min();
        System.out.println("min " + (min.isPresent() ? min.getAsLong() : -1));

        OptionalDouble avg = IntStream.rangeClosed(1, 10).average();
        System.out.println("average " + (avg.isPresent() ? avg.getAsDouble() : -1));
    }
}
