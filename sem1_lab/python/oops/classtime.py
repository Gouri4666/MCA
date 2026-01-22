class Time:
    def __init__(self, hour, minute, second):
        self.__hour = hour      # private attribute
        self.__minute = minute  # private attribute
        self.__second = second  # private attribute

    def __add__(self, other):
        # Add seconds, minutes, and hours
        total_sec = self.__second + other.__second
        total_min = self.__minute + other.__minute + total_sec // 60
        total_hr = self.__hour + other.__hour + total_min // 60

        # Adjust values to proper format
        total_sec = total_sec % 60
        total_min = total_min % 60
        total_hr = total_hr % 24   # optional (wrap after 24 hours)

        return Time(total_hr, total_min, total_sec)

    def show(self):
        print(f"{self.__hour:02d}:{self.__minute:02d}:{self.__second:02d}")


# --- Example usage ---
t1 = Time(5, 45, 50)
t2 = Time(4, 30, 25)

print("First Time: ", end="")
t1.show()

print("Second Time:", end=" ")
t2.show()

t3 = t1 + t2   # uses the overloaded '+' operator
print("Sum of Time:", end=" ")
t3.show()

