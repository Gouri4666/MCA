// Person class
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

// Employee class inheriting Person
class Employee extends Person
{
    int empId;
    String companyName;
    String qualification;
    double salary;

    Employee(String name, String gender, String address, int age,
             int empId, String companyName, String qualification, double salary)
    {
        super(name, gender, address, age);
        this.empId = empId;
        this.companyName = companyName;
        this.qualification = qualification;
        this.salary = salary;
    }
}

// Teacher class inheriting Employee
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
        System.out.println("Teacher Details");
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
        System.out.println();
    }
}

// Main class
class TeacherDemo
{
    public static void main(String[] args)
    {
        int n = 2; // Number of teachers

        Teacher[] t = new Teacher[n];

        t[0] = new Teacher("Anu", "Female", "Kochi", 30,
                           101, "ABC School", "MSc", 45000,
                           1, "Maths", "Science");

        t[1] = new Teacher("Rahul", "Male", "Trivandrum", 35,
                           102, "XYZ School", "MA", 48000,
                           2, "English", "Arts");

        // Display details of N teachers
        for (int i = 0; i < n; i++)
        {
            t[i].display();
        }
    }
}
