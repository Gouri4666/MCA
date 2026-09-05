import department.Department;
import course.Course;
import student.Student;

public class Main {

    public static void main(String[] args) {

        Department dept = new Department("Computer Science", "Kerala");

        // Course 1
        Course course1 = new Course("Java Programming", 6);
        course1.addStudent(new Student("Anu", 5));
        course1.addStudent(new Student("Rahul", 2));
        course1.addStudent(new Student("Meera", 1));
        course1.addStudent(new Student("Arjun", 4));
        course1.addStudent(new Student("Diya", 3));

        // Course 2
        Course course2 = new Course("Data Structures", 4);
        course2.addStudent(new Student("Akhil", 3));
        course2.addStudent(new Student("Sneha", 1));
        course2.addStudent(new Student("Nikhil", 5));
        course2.addStudent(new Student("Vishnu", 2));
        course2.addStudent(new Student("Pooja", 4));

        // Add courses to department
        dept.addCourse(course1);
        dept.addCourse(course2);

        // Display all details
        dept.displayDetails();
    }
}
