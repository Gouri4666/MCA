import pandas as pd
df=pd.DataFrame({
    "A":[1,2,3,4],
    "B":["one","two","Three","four"]
})
print(df)
new_row={"A":5,"B":"five"}

pos=3

print(df.iloc[:pos])