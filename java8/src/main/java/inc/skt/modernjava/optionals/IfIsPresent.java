package inc.skt.modernjava.optionals;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Optional;

public class IfIsPresent {

    public static void main(String[] args) {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        if(studentOptional.isPresent()) {
            System.out.println("Optional is present");
        } else {
            System.out.println("Optional is Not present");
        }

        studentOptional.ifPresent(student -> System.out.println(student.getName()));

    }
}
