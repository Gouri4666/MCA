// Custom Exception
import java.util.*;
class OutOfStockException extends Exception {
    OutOfStockException(String msg) {
        super(msg);
    }
}
class Product {
    String name;
    int stock;

    Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Stock Available: " + stock);
    }

    void purchase(int qty) throws OutOfStockException {

        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (qty > stock) {
            throw new OutOfStockException("Quantity greater than stock!");
        }

        stock -= qty;
        System.out.println("Purchase successful!");
        System.out.println("Remaining stock: " + stock);
    }
}
class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p = new Product("Pen", 10);

        System.out.println("\n--- Product Details ---");
        p.display();

        System.out.print("\nEnter quantity to purchase: ");
        int qty = sc.nextInt();

        try {
            p.purchase(qty);

            System.out.println("\n--- Updated Product Details ---");
            p.display();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

// output
//     --- Product Details ---
// Product Name: Pen
// Stock Available: 10

// Enter quantity to purchase: 23
// Quantity greater than stock!
