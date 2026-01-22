#check a list is sorted
l1=[1,2,3,4,5]
def is_sorted(lst):
    return lst == sorted(lst)
print(is_sorted(l1))  # Output: True
