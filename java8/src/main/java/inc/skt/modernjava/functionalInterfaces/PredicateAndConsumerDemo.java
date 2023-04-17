package inc.skt.modernjava.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerDemo {

    static List<Student> studentList = StudentDatabase.getAllStudents();
    static Predicate<Student> p1 = student -> student.getGrade() >= 3;
    static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

    static BiConsumer<String, List<String>> biConsumer = (name,activities) -> System.out.println(name + " "+ activities);


    private static void printNamesAndActivities() {
        studentList.forEach(student -> {
            if(p1.and(p2).test(student)) {
                biConsumer.accept(student.getName(), student.getActivities());
            }
        });
    }

    public static void main(String[] args) {
        printNamesAndActivities();
    }
}
