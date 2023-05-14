package inc.skt.modernjava.terminalOperations;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningDemo {

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        String names = studentList.stream().map(student -> student.getName()).collect(Collectors.joining());
        System.out.println(names);

        String namesWithDelimiter = studentList.stream().map(student -> student.getName()).collect(Collectors.joining("-"));
        System.out.println(namesWithDelimiter);

        String namesWithPrefixAndSuffix = studentList.stream()
                .map(student -> student.getName())
                .collect(Collectors.joining("-","***** "," *****"));
        System.out.println(namesWithPrefixAndSuffix);
    }
}
