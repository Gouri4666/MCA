class Bank:
    def __init__(self,accno,name,type,balance=0):
        self.accno=accno
        self.name=name
        self.type=type
        self.balance=balance
    def depo(self,dep_amount):
        self.dep_amount=dep_amount
        self.balance+=dep_amount
        print(f"Deposited Rs.{dep_amount}")
        print(f"Balance: Rs.{self.balance}")
    def withdraw(self,with_amount):
        self.with_amount=with_amount
        if with_amount<=self.balance:
            self.balance-=with_amount
            print(f"Withdrawn amount Rs.{with_amount}")
            print(f"Balance: {self.balance}")
        else:
            print("Insufficient Balanace")
        
accno=int(input("Enter Acount number:"))
name=input("Enter name: ")
type=input("Enter account type: ")

b1=Bank(accno,name,type,500)
choice=int(input("Select choice:\n\t1.Deposit\n\t2.Withdraw\nEnter choice:"))
if choice==1:   
    dep_amount=int(input("Enter amount to deposit: "))
    b1.depo(dep_amount)
elif choice==2:
    with_amount=int(input("Enter amount to withdraw: "))
    b1.withdraw(with_amount)
else:
    print("Invalid choice!")

