import java.util.*;

class Attendee {

    String name;
    String email;
    int registrationId;

    Attendee(String name, String email, int registrationId) {
        this.name = name;
        this.email = email;
        this.registrationId = registrationId;
    }

    public int hashCode() {
        return registrationId;
    }

    public boolean equals(Object obj) {
        Attendee a = (Attendee) obj;
        return this.registrationId == a.registrationId;
    }
}

public class AttenteeDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<Attendee> attendees = new HashSet<>();

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

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Registration ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Attendee a = new Attendee(name, email, id);

                    if(attendees.add(a))
                        System.out.println("Registered Successfully");
                    else
                        System.out.println("Duplicate Registration ID");

                    break;

                case 2:

                    System.out.println("\nAttendee List:");

                    for(Attendee at : attendees)
                        System.out.println(at.registrationId + " " + at.name + " " + at.email);

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
