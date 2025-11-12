pos = int(input("Enter the line number to delete: "))

f = open('f1.txt', "r")
lines = f.readlines()
f.close()

if pos <= 0 or pos > len(lines):
    print("Invalid line number!")
else:
    deleted_line = lines.pop(pos - 1)   # remove the line

    f = open('f1.txt', "w")
    f.writelines(lines)
    f.close()

    print("Deleted line:", deleted_line.strip())
