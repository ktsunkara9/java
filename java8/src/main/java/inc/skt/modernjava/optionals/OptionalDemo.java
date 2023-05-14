package inc.skt.modernjava.optionals;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Optional;

public class OptionalDemo {
    private static String getStudentName() {
//        Student student = StudentDatabase.studentSupplier.get();
        Student student = null;
        if(student != null) {
            return  student.getName();
        }
        return null;
    }

    private static Optional<String> getStudentNameOptional() {
       Optional<Student> studentOptional= Optional.ofNullable(StudentDatabase.studentSupplier.get());
       if(studentOptional.isPresent()) {
           return studentOptional.map(student -> student.getName());
       }
       return Optional.empty();
    }
    public static void main(String[] args) {

        String name = getStudentName();
        if(name !=null) {
            System.out.println(name);
        } else {
            System.out.println("name not found");
        }

        Optional<String> nameOptional = getStudentNameOptional();
        if(nameOptional.isPresent()) {
            System.out.println(nameOptional.get());
        } else {
            System.out.println("Name not found");
        }
    }
}
