f1 = open('f1.txt', 'r')
f2 = open('f2.txt', 'w')

line = f1.readline()
while line:
    f2.write(line)
    line = f1.readline()

f1.seek(0)
print("Contents in file:\n",f1.read())

f1.close()
f2.close()
