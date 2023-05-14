package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByClassifierDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Map<String, List<Student>> groupByGender = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGender()));
        System.out.println("Group By Gender "+groupByGender);

        Map<String, List<Student>> groupByGrade = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGrade() > 2 ? "Grade A": "Grade B"));
        System.out.println("Group By Grade "+groupByGrade);
    }
}
