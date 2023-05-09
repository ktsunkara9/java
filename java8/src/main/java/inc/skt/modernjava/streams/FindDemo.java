package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.Optional;

public class FindDemo {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        // Find any Student with GPA >= 3.9
        Optional<Student> anyStudentWithGpa= studentList.stream().filter(student -> {
            System.out.println(student);
            return student.getGpa() >= 3.9;
        }).findAny();
        if(anyStudentWithGpa.isPresent()) {
            System.out.println("Using findAny " + anyStudentWithGpa.get());
        } else {
            System.out.println("Student not found");
        }

        // Find First Student with GPA >= 3.9
        Optional<Student> firstStudentWithGpa= studentList.stream().filter(student -> {
            System.out.println(student);
            return student.getGpa() >= 3.9;
        }).findFirst();
        if(firstStudentWithGpa.isPresent()) {
            System.out.println("Using findFirst " + firstStudentWithGpa.get());
        } else {
            System.out.println("Student not found");
        }
    }
}
