class Student {
    private int rollNo;
    private String name;
    private int marks;

    // Constructor
    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    int getMarks() {
        return marks;
    }

    void display(int rank) {
        System.out.println(rollNo + "\t" + name + "\t" + marks + "\t" + rank);
    }
}

public class StudentRanking {
    public static void main(String[] args) {

        // Declare array of objects
        Student[] s = new Student[4];

        // Input details one by one
        s[0] = new Student(101, "Anu", 92);
        s[1] = new Student(102, "Rahul", 85);
        s[2] = new Student(103, "Maya", 96);
        s[3] = new Student(104, "Kiran", 78);

        int n = s.length;

        // Sort students by marks (Descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[i].getMarks() < s[j].getMarks()) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        // Display students with rank
        System.out.println("Roll\tName\tMarks\tRank");
        System.out.println("--------------------------------");
        for (int i = 0; i < n; i++) {
            s[i].display(i + 1);   // rank = index + 1
        }
    }
}
