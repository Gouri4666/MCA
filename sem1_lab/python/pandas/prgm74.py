import numpy as np
import matplotlib.pyplot as plt

# Generate samples
samples = np.random.normal(loc=10, scale=3, size=1000)

print("Sample mean:", np.mean(samples))
print("Sample std:", np.std(samples))

# Plot histogram
plt.hist(samples, bins=30)
plt.title("Histogram of Normal Distribution Samples")
plt.xlabel("Value")
plt.ylabel("Frequency")
plt.show()
