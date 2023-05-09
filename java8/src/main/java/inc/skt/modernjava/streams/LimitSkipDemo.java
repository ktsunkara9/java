package inc.skt.modernjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitSkipDemo {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(6, 7, 8, 9, 3);

        Optional<Integer> optionalSumOfFirstTwoNumbers= numList.stream().limit(2).reduce((a, b) -> a+b);
        if(optionalSumOfFirstTwoNumbers.isPresent()) {
            System.out.println("SumOfFirstTwoNumbers "+optionalSumOfFirstTwoNumbers.get());
        }

        Optional<Integer> optionalSumAfterSkippingFirstTwoNumbers= numList.stream().skip(2).reduce((a,b) -> a+b);
        if(optionalSumAfterSkippingFirstTwoNumbers.isPresent()) {
            System.out.println("SumAfterSkippingFirstTwoNumbers "+optionalSumAfterSkippingFirstTwoNumbers.get());
        }

    }
}
