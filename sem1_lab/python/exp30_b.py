#check divisible by 5
div=lambda x:'divisible' if not x%5 else 'false'
n=int(input("Enter a number: "))
print(div(n))