package inc.skt.modernjava.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerInterfaceDemo {

    static List<Student> studentList = StudentDatabase.getAllStudents();
    static Consumer<Student> c1 = (student) -> System.out.println(student);
    static Consumer<Student> c2 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());

    static void printNames() {
        studentList.forEach(c1);
    }

    static void printNameAndActivities() {
        studentList.forEach(c2.andThen(c3));
    }

    static void printStudentsWithGrade(int grade) {
        List<Student> studentsWithGrade = studentList.stream()
                .filter(student -> student.getGrade() == 3)
                .collect(Collectors.toList());
        studentList.forEach((student -> {
            if(student.getGrade() >= 3) {
               c2.andThen(c3).accept(student);
            }
        }));
    }
    public static void main(String[] args) {
        String sign= "skt";
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase() + sign);
        consumer.accept("skt");

        // print names of all students
        System.out.println("*************print names of all students*********");
        printNames();

        // print name and then activities
        System.out.println("*************print name and then activities*********");
        printNameAndActivities();

        // print Name & Activities of students whose grade is greater than or equal to 3
        System.out.println("*************print name and activities whose grade is greater than or equal to 3*********");
        printStudentsWithGrade(3);
    }
}
