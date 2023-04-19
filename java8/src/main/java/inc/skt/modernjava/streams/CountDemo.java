package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.stream.Collectors;

public class CountDemo {
    public static void main(String[] args) {
        long numberOfStudents= StudentDatabase.getAllStudents().stream().count();
        System.out.println("numberOfStudents "+ numberOfStudents);

        long numberOfActivities = StudentDatabase.getAllStudents().stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .distinct()
                .count();
        System.out.println("numberOfActivities "+numberOfActivities);
    }
}
