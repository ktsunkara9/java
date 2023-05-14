package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PartitionByDemo {

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Map<Boolean, List<Student>> gpaMap = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa() >= 3.6));
        System.out.println(gpaMap);

        Map<Boolean, Set<Student>> gpaMap1 = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa() >= 3.6, Collectors.toSet()));
        System.out.println(gpaMap1);
    }
}
