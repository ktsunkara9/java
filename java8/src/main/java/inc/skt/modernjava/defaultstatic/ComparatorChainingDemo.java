package inc.skt.modernjava.defaultstatic;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.Comparator;
import java.util.List;

public class ComparatorChainingDemo {

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        System.out.println("before sort "+studentList);

        Comparator<Student> nameComparator = Comparator.comparing(student -> student.getName());
        studentList.sort(nameComparator);
        System.out.println("after sort by name " +studentList);

        Comparator<Student> gradeComparator= Comparator.comparing(Student::getGrade).reversed();
        studentList.sort(gradeComparator);
        System.out.println("after sort by grade " + studentList);

        studentList.sort(nameComparator.thenComparing(gradeComparator));
        System.out.println("after comparator chaining" + studentList);

        studentList.sort(gradeComparator.thenComparing(nameComparator));
        System.out.println("sortBy Grade And Name"+studentList);
    }
}
