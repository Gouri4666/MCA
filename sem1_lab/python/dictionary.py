students = {}

n = int(input("Number of students: "))
for i in range(n):
    name = input("Name: ")
    mark = int(input("Mark: "))
    students[name] = mark

print("Students scoring above 50:")
for k, v in students.items():
    if v > 50:
        print(k, v)
