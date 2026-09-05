package course;

import java.util.ArrayList;
import java.util.Collections;
import student.Student;

public class Course {

    private String courseName;
    private int courseDuration;
    private ArrayList<Student> students;

    public Course(String courseName, int courseDuration) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayStudents() {
        Collections.sort(students); // sort by rank
        for (Student s : students) {
            System.out.println("    " + s);
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }
}
