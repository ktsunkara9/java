package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> studentsOrderedByName = StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(student -> student.getName()))
                .collect(Collectors.toList());
        System.out.println(studentsOrderedByName);

        List<Student> studentsOrderedByGpa = StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(student -> student.getGpa()))
                .collect(Collectors.toList());
        System.out.println(studentsOrderedByGpa);

        List<Student> studentsOrderedByGpaDesc = StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing((Student student) -> student.getGpa()).reversed())
                .collect(Collectors.toList());
        System.out.println(studentsOrderedByGpaDesc);
    }
}
