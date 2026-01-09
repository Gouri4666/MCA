try:
	month=int(input("Enter a month: "))
	if month<1 or month>12:
		raise Exception("Invalid month")
except ValueError:
	print("ENter numbers only")
except Exception as e:
	print(e)

else:
	print("Valid month")
finally:
	print("Completed")
		