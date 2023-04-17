package inc.skt.modernjava.declerative;

import java.util.stream.IntStream;

public class SumOfNumbersApp {
    public static void main(String[] args) {
        // Imperative Style of Programming
        int sum = 0;
        for(int i=1; i<=100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

        // Declarative Style of Programming
        int sum2 = IntStream.rangeClosed(1,100).sum();
        System.out.println(sum2);
    }
}
