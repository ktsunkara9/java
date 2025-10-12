package inc.skt.modernjava.parallelStreams;

import java.util.stream.IntStream;

public class NoParallelStreamDemo2 {
    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1, 1000)
                .forEach(number -> sum.performSum(number));
        System.out.println(sum.getTotal());

        Sum sum1 = new Sum();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(sum1::performSum);
        System.out.println(sum1.getTotal());
    }
}

class Sum {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void performSum(int input) {
        total += input;
    }
}
