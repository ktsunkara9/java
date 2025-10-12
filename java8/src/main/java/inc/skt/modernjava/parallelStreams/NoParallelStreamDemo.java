package inc.skt.modernjava.parallelStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NoParallelStreamDemo {

    private static int sumUsingSequentialStream(List<Integer> numbers) {
        long start = System.currentTimeMillis();
        int sum = numbers.stream()
                .reduce(0, (x,y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("time taken using sequential stream "+(end - start));
        return sum;
    }

    private static int sumUsingParallelStream(List<Integer> numbers) {
        long start = System.currentTimeMillis();
        int sum = numbers.stream()
                .parallel()
                .reduce(0, (x,y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("time taken using parallel stream " + (end - start));
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> wrappedNumbers = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());
        sumUsingSequentialStream(wrappedNumbers);
        sumUsingParallelStream(wrappedNumbers);
    }
}
