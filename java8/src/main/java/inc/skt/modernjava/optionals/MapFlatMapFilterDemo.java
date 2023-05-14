package inc.skt.modernjava.optionals;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Optional;

public class MapFlatMapFilterDemo {
    public static void main(String[] args) {
        // filter
       Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
       studentOptional.filter(student -> student.getGpa() >= 3.6).ifPresent(student -> System.out.println(student));

       // map
        Optional<String> studentNameOptional = studentOptional
                .filter(student -> student.getGpa() >= 3.6)
                .map(student -> student.getName());
        System.out.println(studentNameOptional.get());

        // flatMap
        Optional<Student> studentOptional2 = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        Optional<String> bikeNameOptional = studentOptional2
                .filter(student -> student.getGpa() >= 3.5)
                .flatMap(student -> student.getBike())
                .map(bike -> bike.getName());
        if(bikeNameOptional.isPresent()) {
            System.out.println("Bike Name "+bikeNameOptional.get());
        }
    }
}

