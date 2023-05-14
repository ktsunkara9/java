package inc.skt.modernjava.defaultstatic;

import java.util.Arrays;
import java.util.List;

public class DefaultStaticDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Multiplier multiplier = new MultiplierImpl();
        System.out.println("Multiplication "+multiplier.multiply(numbers));
        System.out.println("size of the list " + multiplier.size(numbers));
        System.out.println("is Empty " + Multiplier.isEmpty(numbers));
        //System.out.println("is Empty " + multiplier.isEmpty(numbers));//Static method may be invoked on containing interface class only
    }
}

interface Multiplier {
    int multiply(List<Integer> numbers);

    default int size(List<Integer> numbers) {
        return numbers.size();
    }

    public static boolean isEmpty(List<Integer> numbers) {
        return !(numbers.size() > 0);
    }
}

class MultiplierImpl implements Multiplier {
    @Override
    public int multiply(List<Integer> numbers) {
       return numbers.stream().reduce(1,(a,b)-> a * b);
    }

    public static boolean isEmpty(List<Integer> numbers) {
        return true;
    }
}

abstract class MultiplierAbsract {
    public static void abstractMethod() {
        System.out.println("Static method in Abstract class");
    }
}