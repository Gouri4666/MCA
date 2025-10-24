#function to get a new string from given string by adding 'ls' to beg, if already begind with ls return unchanges
def ls(s):
    if s[0:2]=='ls':
        return s
    else:
        return 'ls'+s
s=input("Enter a string: ")
print(ls(s))