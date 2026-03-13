# 🎓 Student Management System (Java + JDBC + MySQL)

A Java backend console application for managing student records using **JDBC** and **MySQL**.

---

## 📌 Getting Started

This project demonstrates how a **Core Java application** connects to a **MySQL database** using **JDBC** and performs **CRUD operations** through a clean, layered architecture.

It is ideal for:
- Backend Intern roles
- Java Fresher interviews
- JDBC & SQL practice

---

## 🛠️ Technologies Used

- Java (JDK 17 / 21)
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse IDE
- Git & GitHub

---

## 📂 Project Structure

The Student Management System follows a layered architecture to maintain clean separation of responsibilities.

The **main package** contains `MainApp.java`, which handles user interaction and menu-driven input.  
The **model package** defines the `Student` class, representing the student entity used across the application.  
The **dao package** contains `StudentDAO.java`, responsible for all database operations such as insert, fetch, update, and delete using JDBC.  
The **util package** includes `DBConnection.java`, which manages the database connection logic.

This structure improves code readability, maintainability, and scalability, and closely resembles real-world backend application design.

📌 **Layered Architecture**

- **Main Layer** → User interaction & menu  
- **DAO Layer** → Database operations  
- **Model Layer** → Student entity  
- **Utility Layer** → Database connection  

---

## 🗄️ Database Setup

### Database

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50)
);
```

---

## 🔌 Database Connection Setup

Update credentials in `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

## ⚙️ Features

1. Add Student  
2. View All Students  
3. Search Student by ID  
4. Update Student  
5. Delete Student  
6. Exit  

---
---
## 📌 Use Case

The use case diagram represents how the user interacts with the system via the console menu.

User Flow:

Start application

Choose operation

Provide input

Database action executed

Result displayed

## 🔁 Sequence Diagram

This diagram shows the interaction flow between:

User

Main Application

DAO Layer

Database

## 🖥️ Output
#### 🧾 Main Menu

===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Choose:

#### ➕ Add Student

Choose: 1
Name: K. Arun Kumar Reddy
Email: arunkumarreddyk890@gmail.com
Course: Java Full Stack
Student Added Successfully

#### 📋 View Students

ID | NAME | EMAIL | COURSE
--------------------------------------
1 | Arun Kumar | arun@gmail.com | Backend Java

#### 🔍 Search Student

Choose: 3
Enter Student ID: 1
Student Found:
1 | Arun Kumar | arun@gmail.com | Backend Java

#### ✏️ Update Student

Choose: 4
Enter Student ID: 1
New Name: Arun K
New Email: arun.k@gmail.com
New Course: Java Backend
Student Updated Successfully

#### ❌ Delete Student

Choose: 5
Enter Student ID: 1
Student Deleted Successfully

## 📱 Visual Output (Console Overview)
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/5c4f5cb3-51e0-4e3f-8087-f20c11164fd9" />
