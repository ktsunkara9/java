package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo {
    public static void main(String[] args) {
        System.out.println(StudentDatabase.getAllStudents());
        List<String> listOfActivities = StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(listOfActivities);
    }
}
