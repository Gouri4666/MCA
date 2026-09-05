a=[5,6,7]
try:
    print(a[5])
except IndexError as e:
    print(e)