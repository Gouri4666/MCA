package student;

public class Student implements Comparable<Student> {

    private String studentName;
    private int rank;

    public Student(String studentName, int rank) {
        this.studentName = studentName;
        this.rank = rank;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getRank() {
        return rank;
    }

    // Sorting based on rank
    @Override
    public int compareTo(Student s) {
        return this.rank - s.rank;
    }

    @Override
    public String toString() {
        return "Student Name: " + studentName + ", Rank: " + rank;
    }
}
