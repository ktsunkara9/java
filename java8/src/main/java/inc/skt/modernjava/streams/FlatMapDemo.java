package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        System.out.println(StudentDatabase.getAllStudents());
        List<List<String>> listOfactivitiesList= StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .collect(Collectors.toList());
        System.out.println(listOfactivitiesList);

        List<String> listOfActivities = StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(listOfActivities);
    }
}
