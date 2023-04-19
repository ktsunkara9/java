package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Map<String, List<String>> studentActivityMap = studentList.stream()
                .filter(student -> student.getGrade() >= 3)
                .filter(student -> student.getGpa() >= 3.9f)
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getActivities()));
        System.out.println(studentActivityMap);
    }
}
