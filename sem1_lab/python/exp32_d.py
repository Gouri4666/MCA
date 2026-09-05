#sum of first n whole numbersa
def sum(n):
    if n==0:
        return 0
    else:
        return n + sum(n - 1)

n = int(input("Enter a number: "))
print(f"Sum of first {n} whole numbers is {sum(n)}")
