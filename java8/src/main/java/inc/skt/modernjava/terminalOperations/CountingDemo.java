package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.stream.Collectors;

public class CountingDemo {

    public static void main(String[] args) {
        long totalNumberOfStudents = StudentDatabase.getAllStudents().stream().collect(Collectors.counting());
        System.out.println(totalNumberOfStudents);
    }
}
