# remove all strings with length less than 5 from a list
words = input("list: ").split()
check = list(filter(lambda w: len(w) >= 5, words))
print(check)
