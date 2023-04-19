package inc.skt.modernjava.methodreference;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerMethodReferenceDemo {

    static Consumer<Student> consumer = student -> System.out.println(student);
    static Consumer<Student> consumerMethodReference = System.out::println;

    static Supplier<List<Student>> studentListSupplier = () -> StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        studentListSupplier.get().forEach(consumer);
        System.out.println("******* Using consumerMethodReference *******");
        studentListSupplier.get().forEach(consumerMethodReference);
    }
}
