import java.util.*;

public class StudentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> students = new HashMap<>();

        int choice;
        char cont;

        do {

            System.out.println("\n1 Add Student");
            System.out.println("2 Search Student");
            System.out.println("3 Display All");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    students.put(id, name);
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();

                    if(students.containsKey(id))
                        System.out.println("Name: " + students.get(id));
                    else
                        System.out.println("Student not found");
                    break;

                case 3:
                    System.out.println("\nStudent List:");
                    for(Map.Entry<Integer,String> entry : students.entrySet())
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("\nDo you want to continue (y/n)? ");
            cont = sc.next().charAt(0);

        } while(cont == 'y' || cont == 'Y');

        sc.close();
    }
}
