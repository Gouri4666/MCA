package department;

import java.util.ArrayList;
import course.Course;

public class Department {

    private String departmentName;
    private String location;
    private ArrayList<Course> courses;

    public Department(String departmentName, String location) {
        this.departmentName = departmentName;
        this.location = location;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void displayDetails() {

        System.out.println("Department Name: " + departmentName);
        System.out.println("Location: " + location);
        System.out.println("----------------------------------");

        for (Course c : courses) {
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Course Duration: " + c.getCourseDuration() + " months");
            System.out.println("Students (Sorted by Rank):");
            c.displayStudents();
            System.out.println();
        }
    }
}
