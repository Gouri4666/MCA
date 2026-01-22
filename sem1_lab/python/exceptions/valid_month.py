try:
    month=int(input("Enter month: "))
    if month<1 or month>12:
        raise Exception("Invalid month")
except Exception as e:
    print(e)
else:
    print("Valid month")
finally:
    print("Exit...")

