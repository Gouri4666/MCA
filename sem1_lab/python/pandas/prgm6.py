import pandas as pd
data={"Name":["rahul","priya","veena"],
      "Age":[28,36,35],
      "Mark":[68,67,80]}

df=pd.DataFrame(data)

print(df)

new_row={"Name":"Gokul","Age":32,"Mark":67}

pos=1

df_top=df.iloc[:pos]
df_bottom=df.iloc[pos:]
df_new=pd.concat([df_top,pd.DataFrame([new_row]),df_bottom],ignore_index=True)
print(df_new)