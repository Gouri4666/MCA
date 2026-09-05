l = list(map(int, input("Enter list: ").split()))

found = False

for i in range(len(l)):
    for j in range(i + 1, len(l)):
        if l[i] == l[j]:
            print("First repeating element:", l[i])
            found = True
            break
    if found:
        break

if not found:
    print("No repeating element")
