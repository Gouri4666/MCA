import re

# Open file in read mode
file = open("f1.txt", "r")
content = file.read()
file.close()

# Find all matching phone numbers (10 digits starting with 6-9)
phone_numbers = re.findall(r'\b[6-9][0-9]{9}\b', content)

# Display results
if phone_numbers:
    print("Valid Phone Numbers found:")
    for number in phone_numbers:
        print(number)
else:
    print("No valid phone numbers found.")
