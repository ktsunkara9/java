package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxReduceDemo {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(6,7,8,4,9,3);
        numList.stream().reduce(0, (x,y) -> x > y ? x : y);
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> System.out.println(student.getName() + " " + student.getGpa()));
        Optional<Student> studentWithMaxGPA = studentList.stream().reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1: s2);
        System.out.println(studentWithMaxGPA.get());
    }
}
