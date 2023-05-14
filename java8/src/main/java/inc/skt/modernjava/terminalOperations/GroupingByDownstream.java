package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByDownstream {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Map<Integer, List<Student>> gradeMap = studentList.stream().collect(Collectors.groupingBy(student -> student.getGrade()));
        System.out.println(gradeMap);

        Map<Integer, Map<String, List<Student>>> gradedMap = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGrade(),
                        Collectors.groupingBy(student -> student.getGpa() > 3.8 ? "OUTSTANDING" : "AVERAGE")));
        System.out.println(gradedMap);

        Map<Integer, Integer> groupByWithSum = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGrade(),
                        Collectors.summingInt(student -> student.getNoteBooks())));
        System.out.println(groupByWithSum);

        Set<String> activities = studentList.stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .collect(Collectors.toSet());
        System.out.println(activities);
    }
}
