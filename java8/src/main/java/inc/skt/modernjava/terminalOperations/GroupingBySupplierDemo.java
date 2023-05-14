package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBySupplierDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Map<Integer, Set<Student>> studentSet = studentList.stream()
                    .collect(Collectors.groupingBy(student -> student.getGrade(),
                    LinkedHashMap::new,
                    Collectors.toSet()));
        System.out.println(studentSet);
    }
}
