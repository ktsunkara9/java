package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;

public class MatchDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        boolean allStudentsHaveGoodGPA= studentList.stream().allMatch(student ->  student.getGpa() >= 3.9);
        System.out.println("allStudentsHaveGoodGPA: " + allStudentsHaveGoodGPA);

        boolean anyStudentsHaveGoodGPA= studentList.stream().anyMatch(student ->  student.getGpa() >= 3.9);
        System.out.println("anyStudentsHaveGoodGPA: " + anyStudentsHaveGoodGPA);

        boolean noStudentsHaveGoodGPA= studentList.stream().noneMatch(student ->  student.getGpa() >= 3.9);
        System.out.println("noStudentsHaveGoodGPA: " + noStudentsHaveGoodGPA);
    }
}
