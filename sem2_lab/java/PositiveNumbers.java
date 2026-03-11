import java.util.*;

class NegativeException extends Exception {
    public NegativeException(String message) {
        super(message);
    }
}

public class PositiveNumbers {

    static void checkNumber(int num) throws NegativeException {
        if (num <= 0)
            throw new NegativeException("Number must be positive");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, num, count = 0;
        float sum = 0;

        System.out.print("Enter N: ");
        N = sc.nextInt();

        while (count < N) {  // loop until exactly N positive numbers are entered
            System.out.print("Enter number " + (count + 1) + ": ");
            num = sc.nextInt();

            try {
                checkNumber(num);
                sum += num;   
                count++;      
            } catch (NegativeException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Please enter a positive number.");
            }
        }

        double average = (double) sum / N;
        System.out.println("Average = " + average);

        sc.close();
    }
}
