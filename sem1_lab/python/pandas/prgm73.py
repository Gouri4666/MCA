import pandas as pd

# Original DataFrame
df = pd.DataFrame({
    "A": [1, 2, 3, 4],
    "B": ["one", "two", "three", "four"]
})

print("Original DataFrame:\n", df)

# Row to insert
new_row = {"A": 99, "B": "inserted"}

# Position where row should be inserted
pos = 2   # 0-based index

# Insert row
df_top = df.iloc[:pos]
df_bottom = df.iloc[pos:]
df_new = pd.concat([df_top, pd.DataFrame([new_row]), df_bottom], ignore_index=True)

print("\nDataFrame after inserting row:\n", df_new)
