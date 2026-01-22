class BankAccount:
    def __init__(self, acc_no, name, acc_type, balance=0):
        self.acc_no = acc_no
        self.name = name
        self.acc_type = acc_type
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        print(f"Deposited ₹{amount}. Current Balance: ₹{self.balance}")

    def withdraw(self, amount):
        if amount > self.balance:
            print("Insufficient balance!")
        else:
            self.balance -= amount
            print(f"Withdrew ₹{amount}. Current Balance: ₹{self.balance}")

    def display(self):
        print(f"Account No: {self.acc_no}")
        print(f"Name: {self.name}")
        print(f"Type: {self.acc_type}")
        print(f"Balance: ₹{self.balance}")


# Example
acc1 = BankAccount(12345, "Gouri", "Savings", 5000)
acc1.display()
acc1.deposit(2000)
acc1.withdraw(2500)
