#slicing
import numpy as np
a=np.array([[[1,2,3],[4,5,6]],
            [[7,8,9],[10,11,12]]])
print(a[1,0,:2])#7,8
print(a[:,:,1])#2,5,8,11
