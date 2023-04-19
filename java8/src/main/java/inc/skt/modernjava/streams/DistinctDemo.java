package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,6,6,6,7,8,8,9);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        List<String> distinctActivities = StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctActivities);
    }
}
