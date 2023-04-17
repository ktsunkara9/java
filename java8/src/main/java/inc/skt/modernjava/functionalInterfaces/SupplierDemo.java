package inc.skt.modernjava.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierDemo {
    static Supplier<List<Student>> studentListSupplier = () -> StudentDatabase.getAllStudents();
    static Consumer<Student> consumer = (student) -> System.out.println(student.getName()+" "+student.getActivities()) ;
    public static void main(String[] args) {
        studentListSupplier.get().forEach(consumer);
    }
}
