import java.io.*;
class Employee implements Serializable
{
    int id;
    String name;
    String dept;
    int salary;
    Employee(int id,String name,String dept,int salary)
    {
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }
}
public class Employeeserializable {

    public static void main(String[] args) {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("f1.txt"));
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("f1.txt")))
            {   
                Employee e=new Employee(1, "priya", "hr", 35000);
                oos.writeObject(e);
                Employee e2=(Employee)ois.readObject();
                System.out.println("Id: "+e2.id);
                System.out.println("Name: "+e2.name);
                System.out.println("dept: "+e2.dept);
                System.out.println("Salary: "+e2.salary);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
