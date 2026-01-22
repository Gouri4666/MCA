#Convert a list of digits into a single number.
lst = list(map(int, input().split()))
num = 0

for i in lst:
    num = num * 10 + i

print(num)