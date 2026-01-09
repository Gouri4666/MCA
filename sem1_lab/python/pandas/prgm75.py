import numpy as np
import matplotlib.pyplot as plt

# Sample ndarray
data = np.array([10, 15, 7, 20])
labels = ["A", "B", "C", "D"]

# Bar Chart
plt.bar(labels, data)
plt.title("Bar Chart")
plt.xlabel("Category")
plt.ylabel("Value")
plt.show()

# Horizontal Bar Chart
plt.barh(labels, data)
plt.title("Horizontal Bar Chart")
plt.xlabel("Value")
plt.ylabel("Category")
plt.show()

# Pie Chart
plt.pie(data, labels=labels, autopct='%1.1f%%')
plt.title("Pie Chart")
plt.show()
