# Library_Task-3

# 📚 Library Management System

This is a simple **Library Management System** built using **Java**. It allows a user to:
- Add new books to the library
- View available and issued books
- Issue books to users
- Return books from users

The project uses 3 main classes:
- `User` – Represents a library user or student
- `Book` – Represents a book in the library
- `Library` – Contains the core logic to manage books (issue, return, view)
- `Main` – Runs the program using a switch-based menu

---

## ✅ Features

### 1. Add Book
Add a new book to the library by providing its ID and title. The book will be stored in the library's collection.

### 2. View Books
Displays the list of all books currently in the library. Each book will be marked as either **Available** or **Issued**, helping users to know which books are ready to borrow.

### 3. Issue Book
Allows a user to borrow a book by specifying its ID. The system checks if the book is available before issuing. Once issued, it's marked as "Issued" and associated with the user.

### 4. Return Book
Allows the user to return a book that they had previously borrowed. The system checks if the book was indeed issued to that user before processing the return.

### 5. Exit
Ends the application safely.

---

## 🛠️ How It Works Internally

- All books are stored in a list.
- Issued books are tracked using a map (book ID → user ID).
- The system uses a **switch-case menu** to navigate between options (Add, View, Issue, Return, Exit).
- Each action is confirmed with user-friendly console messages.

---

## 👤 Who Can Use This
This is a beginner-friendly project for students or anyone learning Java. It introduces:
- Object-Oriented Programming (OOP)
- Collections (ArrayList, HashMap)
- Java control structures (switch, loops)

---

