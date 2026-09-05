import pandas as pd
data={"Name":["rahul","gouri","priya"],
      "Age":[22,23,24],
      "Mark":[100,98,96]}
df=pd.DataFrame(data)
print(df)
print(df["Name"])
print(df["Age"])
print(df["Mark"])
