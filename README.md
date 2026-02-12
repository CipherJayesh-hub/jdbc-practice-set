# 📚 Library Management System — JDBC Project

## 📌 Project Overview

This project is a **Java JDBC-based Library Management System** that performs database operations such as inserting books, registering members, issuing books, and viewing records. It demonstrates how Java applications interact with relational databases using JDBC.

The system connects to a database through a dedicated `DBConnection` class and performs SQL operations using `Statement` and `PreparedStatement`.

---

## ⚙️ Technologies Used

* Java (JDK 8+)
* JDBC API
* MySQL Database
* IntelliJ IDEA (recommended IDE)

---

## 🗂️ Database Tables

The system works with three main tables:

### 1. **books**

Stores book details
Fields:
`book_id, title, author, category, quantity, available`

### 2. **members**

Stores library member details
Fields:
`member_id, name, email, phone, join_date, status`

### 3. **issued_books**

Stores issue/return transactions
Fields:
`issue_id, book_id, member_id, issue_date, return_date, status`

---

## 🚀 Features Implemented

* Add new books (user input)
* Insert predefined book records
* Register new members
* Insert predefined member records
* Issue books (transaction entry)
* View all books list
* Database connection reuse class
* Exception handling for database operations
* Resource management (closing connections)

---

## 📂 Project Structure

```
LibraryManagementSystem/
│
├── DBConnection.java
├── AddNewBook.java
├── BooksDataInsert.java
├── MemberDataInsert.java
├── RegisterNewMember.java
├── issued_booksDataInsert.java
└── ViewAllBooks.java
```

---

## ▶️ How to Run

1. Create database and tables in MySQL.
2. Update credentials inside `DBConnection.java`.
3. Compile all files.
4. Run any class containing `main()` depending on operation:

   * Add book → `AddNewBook`
   * View books → `ViewAllBooks`
   * Insert sample data → respective insert classes

---

## 💡 JDBC Concepts Demonstrated

* Database connection handling
* SQL INSERT & SELECT operations
* PreparedStatement vs Statement
* ResultSet traversal
* Exception handling
* Resource cleanup

---

## 🎯 Learning Purpose

This project is designed for **JDBC beginners** to understand:

* How backend systems talk to databases
* How CRUD operations work internally
* How real-world database modules are structured

---


⭐ *This project is a practice-based implementation created for learning JDBC and backend fundamentals.*
