package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {
        List<Student> maleStudentList = StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("male"))
                .filter(student -> student.getGpa() >= 4)
                .collect(Collectors.toList());
        System.out.println(maleStudentList);
    }
}
