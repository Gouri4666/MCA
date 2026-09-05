f = open("f1.txt", "r")
content = f.read()
f.close()

words = content.split()

if len(words) == 0:
    print("File is empty!")
else:
    longest = max(words, key=len)
    print("Longest word:", longest)
    print("Length:", len(longest))
