package inc.skt.modernjava.functionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.List;

public class BiPredicateDemo {

    static Supplier<List<Student>> studentListSupplier = () -> StudentDatabase.getAllStudents();
    static BiPredicate<Integer, Float> biPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
    static Consumer<Student> consumer = (student) -> System.out.println(student.getName() + " " + student.getActivities());

    public static void main(String[] args) {
        studentListSupplier.get().forEach(student -> {
            if(biPredicate.test(student.getGrade(), student.getGpa())) {
                consumer.accept(student);
            }
        });
    }
}
