with open("demo.txt","r") as f1:
    lines=f1.read()
print(lines)
print("New list:")
new=lines.replace("Vinu","Vinay")
print(new)