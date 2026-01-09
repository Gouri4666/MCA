f=open("file1.txt","r")
words=f.read().split()
words.sort(key=len,reverse=True)
length=len(words[0])
for items in words:
    if len(items)==length:
        print(items)

