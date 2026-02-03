import java.util.Scanner;

class Zoo {

    String name;
    String[] regions;

    Zoo(String name, String[] regions) {
        this.name = name;
        this.regions = regions;
    }

    // Inner class
    class Enclosure {
        String name, type;
        String[] animals;

        Enclosure(String name, String type, String[] animals) {
            this.name = name;
            this.type = type;
            this.animals = animals;
        }

        void show() {
            System.out.println("\nEnclosure: " + name);
            System.out.println("Type: " + type);
            System.out.print("Animals: ");
            for (String a : animals) System.out.print(a + " ");
            System.out.println();
        }
    }

    // Static nested class
    static class Contact {
        String address, phone;

        Contact(String address, String phone) {
            this.address = address;
            this.phone = phone;
        }

        void show() {
            System.out.println("\nAddress: " + address);
            System.out.println("Phone: " + phone);
        }
    }

    void showZoo() {
        System.out.print("\nZoo Name: " + name + "\nRegions: ");
        for (String r : regions) System.out.print(r + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Zoo Name: ");
        String zname = sc.nextLine();

        System.out.print("How many regions? ");
        int n = sc.nextInt();
        sc.nextLine();   // clear buffer

        String[] regions = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Region " + (i + 1) + ": ");
            regions[i] = sc.nextLine();
        }

        Zoo zoo = new Zoo(zname, regions);

        System.out.print("Address: ");
        String addr = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();

        Contact contact = new Contact(addr, phone);

        String[] animals1 = {"Lion", "Elephant"};
        String[] animals2 = {"Parrot", "Eagle"};
        String[] animals3 = {"Fish", "Turtle"};

        Enclosure e1 = zoo.new Enclosure("Grassland", "Outdoor", animals1);
        Enclosure e2 = zoo.new Enclosure("Flyzone", "Indoor", animals2);
        Enclosure e3 = zoo.new Enclosure("Aquatic", "Outdoor", animals3);

        zoo.showZoo();
        contact.show();
        e1.show();
        e2.show();
        e3.show();

        sc.close();
    }
}