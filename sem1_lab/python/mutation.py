def nearly_equal(a, b):
    # If length difference is more than 1 → not nearly equal
    if abs(len(a) - len(b)) > 1:
        return False

    diff = 0
    min_len = min(len(a), len(b))

    # Compare characters one by one up to the shortest length
    for i in range(min_len):
        if a[i] != b[i]:
            diff += 1
    
    # Add the extra characters (if any) from longer string
    diff += abs(len(a) - len(b))

    return diff <= 1


# User input
s1 = input("Enter first string: ")
s2 = input("Enter second string: ")

# Output
if nearly_equal(s1, s2):
    print("Nearly Equal")
else:
    print("Not Nearly Equal")
