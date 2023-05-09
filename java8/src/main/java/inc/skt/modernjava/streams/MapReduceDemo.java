package inc.skt.modernjava.streams;

import inc.skt.modernjava.functionalInterfaces.Student;
import inc.skt.modernjava.functionalInterfaces.StudentDatabase;

import java.util.List;

public class MapReduceDemo {
    public static void main(String[] args) {
        List<Student> studentList= StudentDatabase.getAllStudents();
        int totalNoteBooks = studentList.stream()
                .filter(student -> student.getGrade() >=3)
                .filter(student -> student.getGender().equals("male"))
                .map(student-> student.getNoteBooks())
                .reduce(0, (a,b) -> a+b);
        System.out.println("Total Number of Notebooks "+totalNoteBooks);
    }
}
