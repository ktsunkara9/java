package inc.skt.modernjava.optionals;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Optional;

public class OrElseGetThrowDemo {

    private static String optionalOrElse() {
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        String name = studentOptional.map(student -> student.getName()).orElse("Default");
        return name;
    }

    private static String optionalOrElseGet() {
//        Optional<Student> studentOptional =Optional.ofNullable(StudentDatabase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        String name = studentOptional.map(student -> student.getName()).orElseGet(() -> "Default");
        return name;
    }

    private static String optionalOrElseThrow() {
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        String name = studentOptional.map(student -> student.getName()).orElseThrow(() -> new RuntimeException("Data not available"));
        return name;
    }

    public static void main(String[] args) {
        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());
    }
}
