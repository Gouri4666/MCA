#inverted dictioary
# Original dictionary
d = {'a': 1, 'b': 2, 'c': 3}

# Invert it (swap keys and values)
inverted = {v: k for k, v in d.items()}

print("Original:", d)
print("Inverted:", inverted)
