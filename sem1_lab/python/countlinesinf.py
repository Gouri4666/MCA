count = 0
f = open('f1.txt', 'r')

for line in f:
    count += 1

f.close()
print("Number of lines:", count)
