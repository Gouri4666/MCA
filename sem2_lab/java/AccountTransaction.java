//Create an Account class with a balance attribute. Allow two users to access the shared account. While one user deposits money, the other user withdraws money. Write a program that allows concurrent account transactions.
class Account {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal of " + amount);
        }
    }
}

class User1 extends Thread {
    Account acc;

    User1(Account acc) {
        this.acc = acc;
    }

    public void run() {
        acc.deposit(500);
    }
}

class User2 extends Thread {
    Account acc;

    User2(Account acc) {
        this.acc = acc;
    }

    public void run() {
        acc.withdraw(700);
    }
}

public class AccountTransaction {
    public static void main(String[] args) {
        Account acc = new Account();

        User1 u1 = new User1(acc);
        User2 u2 = new User2(acc);

        u1.start();
        u2.start();
    }
}

// output
// Deposited: 500 | Balance: 1500
// Withdrawn: 700 | Balance: 800
