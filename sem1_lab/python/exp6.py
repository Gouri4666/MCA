#lake a list and return a list with unique elemnets
l=list(map(int,input("Enter the elements of the list separated by space: ").split()))
def unique(l):
    if l:
        l1=set(l)
        return l1
    else:
        return "List is empty"
print("List with unique elements:",unique(l))