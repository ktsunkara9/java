package inc.skt.modernjava.methodreference;

import inc.skt.modernjava.functionalInterfaces.Student;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceDemo {
    static Supplier<Student> studentSupplier = Student::new;

    static Function<String, Student> studentFunction = Student::new;
    static BiFunction<String, Integer, Student> studentBiFunction = Student::new;
    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("Krishna"));
        System.out.println(studentBiFunction.apply("Krishna", 3));
    }
}
