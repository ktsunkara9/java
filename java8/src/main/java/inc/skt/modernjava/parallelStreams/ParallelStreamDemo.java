package inc.skt.modernjava.parallelStreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamDemo {

    public static void main(String[] args) {
        System.out.println(sumSequentialStream());
        System.out.println(sumParallelStream());
        System.out.println(checkPerformanceResult(ParallelStreamDemo::sumSequentialStream, 20));
        System.out.println(checkPerformanceResult(ParallelStreamDemo::sumParallelStream, 20));
    }

    private static int sumSequentialStream() {
        return IntStream.rangeClosed(1,10000000).sum();
    }

    private static int sumParallelStream() {
        return IntStream.rangeClosed(1,10000000).parallel().sum();
    }

    private static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes) {
        long startTime = System.currentTimeMillis();
        for(int i=0; i<numberOfTimes; i++) {
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
