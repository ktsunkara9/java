package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByMaxMinCollectingAndThen {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        Map<Integer, Optional<Student>> map = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.maxBy(Comparator.comparing(student -> student.getGpa()))));
        System.out.println(map);

        Map<Integer, Student> maxMap1 =studentList.stream().collect(Collectors.groupingBy(student -> student.getGrade(),
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
        System.out.println(maxMap1);

        Map<Integer, Optional<Student>> minMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.minBy(Comparator.comparing(Student::getGpa))));
        System.out.println(minMap);

        Map<Integer, Student> minMap1 = studentList.stream().collect(Collectors.groupingBy(Student::getGrade,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(student -> student.getGpa())), Optional::get)));
        System.out.println(minMap1);
    }
}
