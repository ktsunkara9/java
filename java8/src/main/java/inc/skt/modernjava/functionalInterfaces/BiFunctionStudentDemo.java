package inc.skt.modernjava.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class BiFunctionStudentDemo {
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Float>> biFunction = ((students, p1) -> {
        Map<String, Float> studentGPAMap = new HashMap<String, Float>();
        students.forEach(student -> {
            if(p1.test(student)) {
                studentGPAMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGPAMap;
    });
    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDatabase.getAllStudents(), PredicateStudentDemo.p2));
    }
}
