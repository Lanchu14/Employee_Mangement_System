# 🧾 Employee Management System

A **Java Swing GUI application** for managing employee records. It allows adding, viewing, and removing employee details with a clean interface, connected to a MySQL database using JDBC.

---

## 💡 Features

- ✅ Add new employees (with auto-generated Employee ID)
- 🔍 View selected employee details
- ❌ Remove employees
- 🎨 Built using Java Swing
- 💾 MySQL database integration

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Java Swing (GUI)
- MySQL
- JDBC (Java Database Connectivity)

---

## 📁 Project Structure

employee.management.system/
│
├── addemployee.java # Add new employee UI & logic
├── viewemployee.java # View employee by ID
├── removeemployee.java # Remove employee by ID
├── main_class.java # Main dashboard
├── com.java # MySQL DB connection class
├── login.java # (Optional) Login screen
└── icons/ # UI background image files
---

## 🧪 Database Setup

Run the following in MySQL:

```sql
CREATE DATABASE employeeDB;
USE employeeDB;

CREATE TABLE employee (
  empId VARCHAR(20) PRIMARY KEY,
  name VARCHAR(100),
  fname VARCHAR(100),
  dob VARCHAR(20),
  salary VARCHAR(20),
  address VARCHAR(255),
  phone VARCHAR(15),
  aadhaar VARCHAR(20),
  email VARCHAR(100),
  education VARCHAR(100),
  designation VARCHAR(100)
);

Update the credentials in com.java:
Connection conn = DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/employeeDB",
  "yourUsername", "yourPassword"
);

▶️ How to Run
Clone the repo:
git clone https://github.com/yourusername/Employee_Management_System.git
cd Employee_Management_System

Compile the files:
javac employee/management/system/*.java

Run the app:
java employee.management.system.main_class

✍️ Author

Lanchan J
GitHub: Lanchu14

📜 License
This project is licensed under the MIT License.

⭐ Star this repo if you find it useful!
---
Let me know if you want the email added or screenshots section included!
