import java.util.*;

interface Showable
{
    public void show();
}
class Person
{
    String name;
    String gender;
    long phone;
    Person(String name,String gender,long phone)
    {
        this.name=name;
        this.gender=gender;
        this.phone=phone;
    }
}
class Student extends Person
{
    String course;
    int score;
    Student(String name,String gender,long phone,String course,int score)
    {
        super(name,gender,phone);
        this.course=course;
        this.score=score;
    }
}
class PGStudent extends Student implements Showable
{
    String researchArea;
    String guide;
    PGStudent(String name,String gender,long phone,String course,int score,String researchArea,String guide)
    {
        super(name,gender,phone,course,score);
        this.researchArea=researchArea;
        this.guide=guide;
    }
    public void show()
    {
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Phone: "+phone);
        System.out.println("Course: "+course);
        System.out.println("Score: "+score);
        System.out.println("Research Area: "+researchArea);
        System.out.println("Guide: "+guide);
                
    }
}

public class PGStudentDemo
{
    public static void main(String [] args)
    {
        PGStudent [] p=new PGStudent[3];
        p[0]=new PGStudent("Gouri","female",9745245,"MCA",45,"CS","Kiran");
        p[1]=new PGStudent("Prita","female",9745245,"MCA",78,"Mal","Kiran");
        p[2]=new PGStudent("Gouri","female",9745245,"MCA",23,"ACN","Kiran");
        //rank on score
        System.out.println("rank on score");
        Arrays.sort(p,(s1,s2)->Integer.compare(s2.score,s1.score));
        for(int i=0;i<p.length;i++)
        {
            System.out.println("\nRank"+(i+1));
            p[i].show();
        }
        //sort on reaseach area
        System.out.println("\nSort on research area");
        Arrays.sort(p,Comparator.comparing(s->s.researchArea));
        for(int i=0;i<p.length;i++)
        {
            p[i].show();
        }
    }
}


// rank on score

// Rank1
// Name: Prita
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 78
// Research Area: Mal
// Guide: Kiran

// Rank2
// Name: Gouri
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 45
// Research Area: CS
// Guide: Kiran

// Rank3
// Name: Gouri
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 23
// Research Area: ACN
// Guide: Kiran

// Sort on research area
// Name: Gouri
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 23
// Research Area: ACN
// Guide: Kiran
// Name: Gouri
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 45
// Research Area: CS
// Guide: Kiran
// Name: Prita
// Gender: female
// Phone: 9745245
// Course: MCA
// Score: 78
// Research Area: Mal
// Guide: Kiran
