package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinMaxByDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Optional<Student> studentWithMinimumGPA = studentList.stream()
                .collect(Collectors.minBy(Comparator.comparing(student -> student.getGrade())));
        if(studentWithMinimumGPA.isPresent()) {
            System.out.println("Student with minimum GPA "+studentWithMinimumGPA.get());
        }

        Optional<Student> studentWithMaxGrade = studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(student -> student.getGrade())));
        if(studentWithMaxGrade.isPresent()) {
            System.out.println("Student with max Grade "+studentWithMaxGrade.get());
        }
    }
}
