import numpy as np
import matplotlib.pyplot as plt
from scipy import optimize

# Function to minimize
def f(x):
    return (x[0] - 3)**2 + 2 * (x[1] + 1)**2 + 0.5 * x[0] * x[1]

# Gradient of the function
def grad_f(x):
    df_dx0 = 2*(x[0] - 3) + 0.5*x[1]
    df_dx1 = 4*(x[1] + 1) + 0.5*x[0]
    return np.array([df_dx0, df_dx1])

# Store optimization path
path = []
def callback(xk):
    path.append(np.copy(xk))

# Starting point
x0 = np.array([8.0, 8.0])

# Optimization (BFGS method)
result = optimize.minimize(
    f,
    x0,
    method='BFGS',
    jac=grad_f,
    callback=callback
)

print("Minimum value:", result.fun)
print("Minimum point:", result.x)

# Convert path to array
path = np.array(path)

# Contour plot for visualization
x_vals = np.linspace(-2, 12, 400)
y_vals = np.linspace(-8, 6, 400)
X, Y = np.meshgrid(x_vals, y_vals)
Z = (X - 3)**2 + 2*(Y + 1)**2 + 0.5*X*Y

plt.contour(X, Y, Z, levels=40)
plt.plot(path[:, 0], path[:, 1], marker='o', color='red')
plt.scatter(result.x[0], result.x[1], color='black', marker='*', s=120)
plt.title("Optimization Path")
plt.xlabel("x0")
plt.ylabel("x1")
plt.show()
