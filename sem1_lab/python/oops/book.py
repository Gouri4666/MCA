class Publisher:
    def __init__(self, name):
        self.name = name

    def display(self):
        print("Publisher Name:", self.name)


class Book(Publisher):
    def __init__(self, name, title, author):
        super().__init__(name)  # calling base class constructor
        self.title = title
        self.author = author

    def display(self):
        super().display()
        print("Book Title:", self.title)
        print("Author:", self.author)


class Python(Book):
    def __init__(self, name, title, author, price, pages):
        super().__init__(name, title, author)
        self.price = price
        self.pages = pages

    # Method overriding
    def display(self):
        super().display()
        print("Price:", self.price)
        print("Pages:", self.pages)


# Example Output
p = Python("O'Reilly", "Learning Python", "Mark Lutz", 850, 1600)
p.display()
