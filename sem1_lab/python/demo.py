import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import minimize

# Function to minimize
def function(x):
    return (x[0] - 2)*2 + (x[1] - 3)*2

# List to store optimization path
path = []

# Callback function to capture each iteration
def record_path(xk):
    path.append(xk)

# Initial guess
initial_guess = [0, 0]

# Perform optimization
result = minimize(
    function,
    initial_guess,
    method='BFGS',
    callback=record_path
)

# Convert path list to array
path = np.array(path)

# Create contour plot
x = np.linspace(-1, 5, 100)
y = np.linspace(-1, 6, 100)
X, Y = np.meshgrid(x, y)
Z = (X - 2)*2 + (Y - 3)*2

plt.contour(X, Y, Z, levels=20)
plt.plot(path[:, 0], path[:, 1], 'ro-', label='Optimization Path')
plt.plot(2, 3, 'bx', markersize=10, label='Minimum Point')
plt.xlabel('X')
plt.ylabel('Y')
plt.title('Numeric Optimization using SciPy')
plt.legend()
plt.show()

# Display result
print("Minimum Point:", result.x)
print("Minimum Value:", result.fun)