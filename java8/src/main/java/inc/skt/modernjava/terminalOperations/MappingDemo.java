package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class MappingDemo {

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        List<String> names = studentList.stream().collect(Collectors.mapping(student -> student.getName(), Collectors.toList()));
        System.out.println(names);
    }
}
