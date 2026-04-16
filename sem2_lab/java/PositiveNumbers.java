import java.util.*;

class NegativeNumberException extends Exception {
    NegativeNumberException(String msg) {
        super(msg);
    }
}

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, num, sum = 0, count = 0;

        System.out.print("Enter how many numbers: ");
        n = sc.nextInt();

        int i = 1;

        while (count < n) {
            try {
                System.out.print("Enter number " + i + ": ");
                num = sc.nextInt();

                if (num < 0) {
                    throw new NegativeNumberException("Negative number not allowed");
                }

                sum += num;
                count++;
                i++;

            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter integer only.");
                sc.next(); // clear wrong input
            }
        }

        double avg = (double) sum / n;
        System.out.println("Average = " + avg);
    }
}
