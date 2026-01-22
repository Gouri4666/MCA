class Bank:
    def __init__(self,accno,bal=500):
        self.accno=accno
        self.bal=bal
    def withdraw(self,amount):
        if self.bal>=amount:
            self.bal-=amount
            print(f"Balance: {self.bal}")

        else:
            print("insufficient balance")
    def deposit(self,amount):
        self.bal+=amount
        print(f"Balance: {self.bal}")
    def display(self):
        print("Account number:",self.accno)
        print("Account Balance:",self.bal)
        


b=Bank(123,500)
ch=int(input("1.withdraw\n2.deposit\n3.display\nEnter choice:"))
if ch==1:
    amount=int(input("enter amount to withdraw:"))
    b.withdraw(amount)
elif ch==2:
    amount=int(input("enter amount to deposit:"))
    b.deposit(amount)
elif ch==3:
    b.display()
else:
    print("Invalid")

        