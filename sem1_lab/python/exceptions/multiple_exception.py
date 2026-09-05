a=[10,"twenty",30]
try:
    sum=int(a[0])+int(a[1])+int(a[2])
except (TypeError,ValueError) as e:
    print(e)
else:
    print(sum)
finally:
    print("Exit...")