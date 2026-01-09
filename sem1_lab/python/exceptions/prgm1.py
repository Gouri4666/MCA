#Division by zero

try:
	a = int ( input (" First number :") )
	b = int ( input (" Second number : ") )
	result = a / b
except ZeroDivisionError:
	print("Division By Zero")
except ValueError:
	print("Invalid number")
else:
	print("Result = ", result)
