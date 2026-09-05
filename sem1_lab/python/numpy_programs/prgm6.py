#reshape()
import numpy as np
a=np.array([[[1,2],[3,4]],
            [[5,6],[7,8]]])
print("Original array: \n",a)
print(a.shape)
b=a.reshape(4,2)
print("Reshaped array:\n",b)