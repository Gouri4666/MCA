class Bank:
    def __init__(self,accno,name,type,bal):
        self.accno=accno
        self.name=name
        self.type=type
        self.bal=bal
    def deposit(self,amount):
        if amount>0:
            self.bal+=amount
            print(f"Amount deposited\nBalance:Rs.{self.bal}")
        else:
            print("Can;t deposit ")
    def withdraw(self,amount):
        if amount<=self.bal:
            self.bal-=amount
            print(f"Amount withdrawn\nBalance:Rs.{self.bal}")
        else:
            print("can't")
    def display(self):
        print(f"Account no:{self.accno}")
        print(f"Account name:{self.name}")
        print(f"Account type:{self.type}")
        print(f"Account balance:{self.bal}")
b1=Bank(123,'gouri','savings',500)
b1.withdraw(500)