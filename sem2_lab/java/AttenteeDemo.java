import java.util.*;
class Attendee {
    String name;
    String email;
    Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
public class AttendeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Attendee> attendees = new HashMap<>();
        int choice;
        do {
            System.out.println("\n1 Add Attendee");
            System.out.println("2 Display Attendees");
            System.out.println("3 Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Enter Registration ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if(attendees.containsKey(id)) {
                        System.out.println("Duplicate Registration ID");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    Attendee a = new Attendee(name, email);
                    attendees.put(id, a);
                    System.out.println("Registered Successfully");
                    break;
                case 2:
                    System.out.println("\nAttendee List:");

                        for(Integer id : attendees.keySet())
                    System.out.println(id + " " + attendees.get(id).name + " " + attendees.get(id).email);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 3);

        sc.close();
    }
}
