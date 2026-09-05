import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int choice;
        char cont;

        do {

            System.out.println("\n1 Add Product");
            System.out.println("2 Sort by Name");
            System.out.println("3 Display Products");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    products.add(new Product(name, price));
                    break;

                case 2:
                    Collections.sort(products, Comparator.comparing(p -> p.name));
                    System.out.println("products:\n");
                    for(Product p : products)
                    System.out.println(p.name);
                    break;

                case 3:
                    System.out.println("\nProduct List:");
                    for(Product p : products)
                        System.out.println(p.name + " - " + p.price);
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
