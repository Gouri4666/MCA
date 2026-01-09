import numpy as np
a=np.array([[1,2,3],[4,5,6]])
#min
print(a.min())
print(a.min(axis=1))
#max
print(a.max())
print(a.max(axis=0))
#sum
print(a.sum())
#cumsum
print(a.cumsum())