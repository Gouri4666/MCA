import java.util.Arrays;
import java.util.Comparator;

interface Showable 
{
    void show();
}
class Person 
{
    String name;
    String gender;
    String phoneNo;
    Person(String name, String gender, String phoneNo) 
    {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }
}

class Student extends Person {

    String course;
    double score;

    Student(String name, String gender, String phoneNo,String course, double score)
    {
        super(name, gender, phoneNo);
        this.course = course;
        this.score = score;
    }
}

class PGStudent extends Student implements Showable 
{
    String researchArea;
    String guide;
    PGStudent(String name, String gender, String phoneNo,
              String course, double score,
              String researchArea, String guide) 
    {
        super(name, gender, phoneNo, course, score);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    public void show() 
    {
        System.out.println("Name          : " + name);
        System.out.println("Course        : " + course);
        System.out.println("Score         : " + score);
        System.out.println("Research Area : " + researchArea);
        System.out.println("Guide         : " + guide);
        System.out.println("--------------------------------");
    }
}
public class PGStudentDemo 
{
    public static void main(String[] args)
     {

        PGStudent[] pg = 
        {
            new PGStudent("Anu", "Female", "9876543210",
                    "MCA", 85, "AI", "Dr. Kumar"),

            new PGStudent("Rahul", "Male", "9123456780",
                    "MCA", 92, "Data Science", "Dr. Smith"),

            new PGStudent("Meera", "Female", "9988776655",
                    "MCA", 78, "Cyber Security", "Dr. John")
        };

        Arrays.sort(pg, (s1, s2) -> Double.compare(s2.score, s1.score));

        System.out.println("=== Ranking Based on Score ===");
        for (int i = 0; i < pg.length; i++) 
        {
            System.out.println("Rank " + (i + 1));
            pg[i].show();
        }

        Arrays.sort(pg, Comparator.comparing(s -> s.researchArea));
        System.out.println("=== Sorted Based on Research Area ===");
        for (PGStudent s : pg) 
        {
            s.show();
        }
    }
}
