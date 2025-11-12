inp = open("f1.txt", "r")
out = open("f2.txt", "w")

for line in inp:
    stripped = line.lstrip()
    if not stripped.startswith("#"):     # If not a comment, write it
        out.write(line)

inp.close()
out.close()

print("Comments removed successfully!")
