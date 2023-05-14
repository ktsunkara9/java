package inc.skt.modernjava.numericStreams;

import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxingDemo {

    public static void main(String[] args) {
        List<Integer> boxedListOfIntegers = IntStream.rangeClosed(1,10)
                                            .boxed()
                                            .collect(Collectors.toList());
        System.out.println("boxedListOfIntegers "+boxedListOfIntegers);

        int sum = boxedListOfIntegers.stream().mapToInt(integer -> integer.intValue()).sum();
        System.out.println("sum "+sum);

        System.out.println("total notebooks "+StudentDatabase.getAllStudents()
                                                        .stream()
                                                        .mapToInt(student -> student.getNoteBooks()).sum());
        System.out.println("total notebooks using reduce "+StudentDatabase.getAllStudents()
                                                                .stream()
                                                                .map(student -> student.getNoteBooks())
                                                                .reduce((x,y) -> x + y));
    }
}
