package inc.skt.modernjava.functionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {

    public static List<Student> getAllStudents() {
        Student student1 = new Student("Ram", 2, 3.6f, "male", 11, Arrays.asList("Archery", "Meditation", "Horse Riding"));
        Student student2 = new Student("Sita", 2, 3.8f, "female", 12, Arrays.asList("Story Telling", "Meditation", "Reading"));

        Student student3 = new Student("Krishna", 3, 4.0f, "male", 10, Arrays.asList("Archery", "Meditation", "Fighting"));
        Student student4 = new Student("Teja", 3, 3.9f, "male", 9, Arrays.asList("Yoga", "Meditation", "Reading"));

        Student student5 = new Student("Sunkara", 4, 3.5f, "male", 15,  Arrays.asList("Coding", "Meditation", "TT"));
        Student student6 = new Student("Pandu", 4, 3.9f, "male", 14, Arrays.asList("Chess", "Yoga", "Reading"));

        List<Student> studentList = Arrays.asList(student1,student2, student3, student4, student5, student6);
        return studentList;
    }
}
