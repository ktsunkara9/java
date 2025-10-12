package inc.skt.modernjava.parallelStreams;

import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamPipelineDemo {

    private static List<String> getStudentActivitiesWithSequentialStream() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getActivities())
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("time taken using sequential stream "+ (endTime - startTime));
        return studentActivities;
    }

    private static List<String> getStudentActivitiesWithParallelStream() {
        long startTime = System.currentTimeMillis();
        List<String> activities = StudentDatabase.getAllStudents()
                .stream()
                .parallel()
                .map(student -> student.getActivities())
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using parallel stream " + (endTime - startTime));
        return activities;
    }
    public static void main(String[] args) {
        getStudentActivitiesWithSequentialStream();
        getStudentActivitiesWithParallelStream();
    }
}
