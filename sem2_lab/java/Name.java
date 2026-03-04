import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Name 
{

    public static void main(String[] args) 
    {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        char continueChoice;

        do 
        {
            System.out.println("\nMENU");
            System.out.println("1.Add Name");
            System.out.println("2.Remove Name");
            System.out.println("3.Search Name");
            System.out.println("4.Sort Names");
            System.out.println("5.Display Names");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter name to add: ");
                    String nameToAdd = sc.nextLine();
                    names.add(nameToAdd);
                    System.out.println("Name added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = sc.nextLine();
                    if (names.remove(nameToRemove)) {
                        System.out.println("Name removed successfully.");
                    } 
                    else 
                    {
                        System.out.println("Name not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = sc.nextLine();
                    if (names.contains(nameToSearch)) {
                        System.out.println("Name found in the list.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 4:
                if (names.isEmpty()) {
                System.out.println("No names to sort.");
                }    
                else 
                {
                Collections.sort(names);
                System.out.println("Names sorted successfully.");
                System.out.println("Sorted List:");
                for (String name : names) {
                System.out.println(name);
               }
                }
                break;

                case 5:
                    System.out.println("List of names");
                    if (names.isEmpty()) {
                        System.out.println("No names in the list.");
                    } else {
                        for (String name : names) {
                            System.out.println(name);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("\nDo you want to continue? (Y/N): ");
            continueChoice = sc.next().charAt(0);
            sc.nextLine();

        } while (continueChoice == 'Y' || continueChoice == 'y');

        System.out.println("Program ended.");
        sc.close();
    }
}
