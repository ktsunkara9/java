package inc.skt.modernjava.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionStudentDemo {
    static Supplier<List<Student>> studentListSupplier = () -> StudentDatabase.getAllStudents();
    static Function<List<Student>, Map<String, Float>> studentMapFunction = (students-> {
        Map<String, Float> studentMap = new HashMap<>();
        students.forEach(student -> {
            studentMap.put( student.getName(), student.getGpa());
        });
        return studentMap;
    });
    public static void main(String[] args) {
        System.out.println(studentMapFunction.apply(studentListSupplier.get()));
    }
}
