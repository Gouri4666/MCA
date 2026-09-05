try:
    f=open('file2.txt',"r")
    data=f.read()
except FileNotFoundError as e:
    print(e)
else:
    print(data)
finally:
    print("Exit...")