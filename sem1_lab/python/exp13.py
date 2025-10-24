#accept strings and find max length , if more than 1 return BINGO
s=input("Enter a sentance: ").split(" ")
lengths=[len(x) for x in s]
print(lengths)
max=max(lengths)
print(max)
res=[x for x in s if len(x)==max]
print(res)
count=len(res)
print(count)
if count>1:
    print('BINGO')
else:
    print(res)