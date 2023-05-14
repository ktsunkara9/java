package inc.skt.modernjava.defaultstatic;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMethodDemo {
    public static void main(String[] args) {
        List<Student> studentList =StudentDatabase.getAllStudents();
        System.out.println(studentList);
        List<Student> sortedStudentList= studentList.stream()
                .sorted(Comparator.comparing(student -> student.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedStudentList);

        List<String> names = Arrays.asList("HBK", "SKT", "HHH", "RKO");
        Collections.sort(names);
        System.out.println(names);

        List<String> stringList = Arrays.asList("from", "of", "throw", "fromEvent");
        stringList.sort(Comparator.naturalOrder());
        System.out.println(stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);
    }
}
