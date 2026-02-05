import java.util.Scanner;

class Person
{
    String name;
    String gender;
    String address;
    int age;

    Person(String name, String gender, String address, int age)
    {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }
}

class Employee extends Person
{
    int empId;
    String companyName;
    String qualification;
    double salary;

    Employee(String name, String gender, String address, int age,int empId, String companyName, String qualification, double salary)
    {
        super(name, gender, address, age);
        this.empId = empId;
        this.companyName = companyName;
        this.qualification = qualification;
        this.salary = salary;
    }
}

class Teacher extends Employee
{
    int teacherId;
    String subject;
    String department;

    Teacher(String name, String gender, String address, int age,
            int empId, String companyName, String qualification, double salary,
            int teacherId, String subject, String department)
    {
        super(name, gender, address, age,
              empId, companyName, qualification, salary);
        this.teacherId = teacherId;
        this.subject = subject;
        this.department = department;
    }

    void display()
    {
        System.out.println("\nTeacher Details");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Employee ID: " + empId);
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: " + salary);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + department);
    }
}

class TeacherDemo2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Teacher[] t = new Teacher[n];

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEnter details of Teacher " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine();

            System.out.print("Company Name: ");
            String companyName = sc.nextLine();

            System.out.print("Qualification: ");
            String qualification = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            System.out.print("Teacher ID: ");
            int teacherId = sc.nextInt();
            sc.nextLine();

            System.out.print("Subject: ");
            String subject = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            t[i] = new Teacher(name, gender, address, age,empId, companyName, qualification, salary,teacherId, subject, department);
        }

        for (int i = 0; i < n; i++)
        {
            t[i].display();
        }

        sc.close();
    }
}
