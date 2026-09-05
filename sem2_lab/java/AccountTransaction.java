//Create an Account class with a balance attribute. Allow two users to access the shared account. While one user deposits money, the other user withdraws money. Write a program that allows concurrent account transactions.


class Account
{
    private int balance=1000;
    synchronized void deposit(int amount)
    {
        balance=balance+amount;
        System.out.println("Deposited");
        System.out.println("New balance: "+balance);
    }
    synchronized void withdraw(int amount)
    {
        if (balance>amount)
        {
            balance=balance-amount;
            System.out.println("Amount withdrawn");
            System.out.println("New balance: "+balance);
        }
        else{
            System.out.println("Insuficient balance");
        }
    }
}

class depositThread extends Thread
{
    Account acc;
    depositThread(Account acc)
    {
        this.acc=acc;
    }
    public void run()
    {
        acc.withdraw(500);
    }
}

class withdrawThread extends Thread
{
    Account acc;
    withdrawThread(Account acc)
    {
        this.acc=acc;
    }
    public void run()
    {
        acc.deposit(1000);
    }
}

public class Test {

    public static void main(String[] args) {
        Account a=new Account();
        depositThread d1=new depositThread(a);
        withdrawThread w1=new withdrawThread(a);
        d1.start();
        w1.start();

    }
}
// output
// // Amount withdrawn
// New balance: 500
// Deposited
// New balance: 1500
