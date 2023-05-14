package inc.skt.modernjava.functionalInterfaces;

import inc.skt.modernjava.optionals.Bike;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student {

    private String name;
    private int grade;
    private float gpa;
    private String gender;
    private int noteBooks;
    List<String> activities = new ArrayList<>();

    private Optional<Bike> bike = Optional.empty();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(String name, int grade, float gpa, String gender) {
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.gender = gender;
    }

    public Student(String name, int grade, float gpa, String gender, List<String> activities) {
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }

    public Student(String name, int grade, float gpa, String gender, int noteBooks, List<String> activities) {
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.gender = gender;
        this.noteBooks = noteBooks;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }
    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }
}
