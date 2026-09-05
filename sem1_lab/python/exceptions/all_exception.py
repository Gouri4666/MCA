#Division by zero

try:
	a = int ( input (" First number :") )
	b = int ( input (" Second number : ") )
	result = a / b
except Exception as e:
	print(e)

else:
	print("Result = ", result)
finally:
	print("program exiting....")