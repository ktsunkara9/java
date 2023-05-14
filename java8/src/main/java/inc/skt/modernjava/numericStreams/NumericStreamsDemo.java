package inc.skt.modernjava.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NumericStreamsDemo {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> sumUsingList =integerList.stream().reduce((x, y) -> x + y);
        if(sumUsingList.isPresent()) {
            System.out.println("sumUsingList "+sumUsingList.get());
        } else {
            System.out.println("sum is not present");
        }

        int sumUsingIntStream = IntStream.rangeClosed(1, 6).sum();
        System.out.println("sumUsingIntStream "+ sumUsingIntStream);

        int sumWithIntStreamRange = IntStream.range(1,6).sum(); // sum of first 5 numbers
        System.out.println("sumWithIntStreamRange "+sumWithIntStreamRange);

    }
}
