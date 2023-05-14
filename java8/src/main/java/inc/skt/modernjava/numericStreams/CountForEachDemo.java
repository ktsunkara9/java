package inc.skt.modernjava.numericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CountForEachDemo {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1,6);
        System.out.println("count " +intStream.count());
        IntStream.rangeClosed(1,6).forEach(val -> System.out.print(val + ","));
        LongStream.range(1, 50).forEach(val -> System.out.print(val + ","));
        IntStream.range(1,50).asDoubleStream().forEach(val -> System.out.print(val+","));
    }
}
