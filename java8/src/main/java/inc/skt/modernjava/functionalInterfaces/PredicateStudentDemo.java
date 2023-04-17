package inc.skt.modernjava.functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentDemo {
    static List<Student> studentList = StudentDatabase.getAllStudents();
    static Predicate<Student> p1 = student -> student.getGrade() >= 3 ;
    static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

    private static void filterStudentsByGradeLevel() {
       studentList.forEach(student -> {
           if(p1.test(student))
               System.out.println(student);
       });
    }

    private static void filterStudentsByGPALevel() {
        studentList.forEach(student -> {
            if(p2.test(student))
                System.out.println(student);
        });
    }

    private static void filterStudentsByGradeAndGPALevel() {
        studentList.forEach(student -> {
            if(p1.or(p2).negate().test(student))
                System.out.println(student);
        });
    }
    public static void main(String[] args) {
        filterStudentsByGradeLevel();

        System.out.println("********** filterStudentsByGPALevel **********");
        filterStudentsByGPALevel();

        System.out.println("********** filterStudentsByGradeAndGPALevel **********");
        filterStudentsByGradeAndGPALevel();
    }
}
