// Custom Exception
import java.util.*;
class OutOfStockException extends Exception {
    OutOfStockException(String message) {
        super(message);
    }
}

class Product {

    String productName;
    int stockQuantity;

    Product(String name, int stock) {
        productName = name;
        stockQuantity = stock;
    }

    void purchase(int quantity) throws OutOfStockException {

        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if(quantity > stockQuantity) {
            throw new OutOfStockException("Not enough stock available");
        }

        stockQuantity -= quantity;

        System.out.println("Purchase successful!");
        System.out.println("Remaining stock: " + stockQuantity);
    }
}

public class ProductPurchase {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Product p = new Product("Laptop", 10);
        System.out.println("Product: "+p.productName+"\nQuantity:"+p.stockQuantity);
        try {
            System.out.println("Enter quantity to purchase: ");
            int q=sc.nextInt();
            p.purchase(q);
        }

        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        catch(OutOfStockException e) {
            System.out.println(e.getMessage());
            
    sc.close();
        }
    }
 } 
// Product: Laptop
// Available Quantity: 10
// Enter quantity to purchase: 55
// Not enough stock available
