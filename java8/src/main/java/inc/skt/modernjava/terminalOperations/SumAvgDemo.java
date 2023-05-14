package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SumAvgDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        int notebooks = studentList.stream()
                .collect(Collectors.summingInt(student -> student.getNoteBooks()));
        System.out.println(notebooks);
        Optional<Integer> totalNotebooks = studentList.stream()
                .map(student -> student.getNoteBooks())
                .reduce((a,b) -> a + b);
        System.out.println("total note books " + totalNotebooks.get());

        double avgNotebooks= studentList.stream().collect(Collectors.averagingInt(student -> student.getNoteBooks()));
        System.out.println(avgNotebooks);

        OptionalDouble averageNotebooks= studentList.stream().mapToInt(student -> student.getNoteBooks()).average();
        System.out.println("average notebooks " + averageNotebooks.getAsDouble());
    }
}
