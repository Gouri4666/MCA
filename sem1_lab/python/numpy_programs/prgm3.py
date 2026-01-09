#sum
import numpy as np
a=np.array([[1,2,3],
            [4,5,6]])
print(a.sum())
print(a.sum(axis=1))
print(a.sum(axis=0))
