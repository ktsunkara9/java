package inc.skt.modernjava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinReduceDemo {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(6, 7, 8, 9, 3);
        Optional<Integer> minValue= numList.stream().reduce((x, y) -> x < y ? x : y);
        System.out.println(minValue.get());
    }
}
