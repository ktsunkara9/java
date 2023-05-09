package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,3,5,7);
        int multiplication = numList.stream().reduce(1, (a,b) -> a*b);
        System.out.println(multiplication);

        int sum = numList.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum);

        Optional<Integer> optionalNumList= numList.stream().reduce((a, b) -> a*b);
        System.out.println(optionalNumList.get());

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> reduceWithEmptyList = emptyList.stream().reduce((a,b) -> a+b);
        System.out.println(reduceWithEmptyList);

        Optional<Student> studentWithMaxGpa = StudentDatabase.getAllStudents()
                .stream()
                .reduce((student1,student2) -> student1.getGpa() > student2.getGpa() ? student1 : student2);
        if(studentWithMaxGpa.isPresent()) {
            System.out.println(studentWithMaxGpa.get());
        }
    }
}
