Java Login System

Project Overview

This is a simple Login System developed using Java Swing and MySQL. It allows users to log in by entering a username and password. The application verifies the credentials stored in the MySQL database.

Features

- User Login
- Username and Password Validation
- MySQL Database Connectivity using JDBC
- Login Success and Error Messages
- Clear Button to Reset Input Fields

Technologies Used

- Java
- Java Swing
- JDBC
- MySQL
- VS Code

Database

Database Name: "StudentDB"

Table Name: "students"

Example table structure:

Field| Type
id| INT
username| VARCHAR(50)
password| VARCHAR(50)

Requirements

- JDK 8 or above
- MySQL Server
- MySQL JDBC Connector
- VS Code (or any Java IDE)

How to Run

1. Install Java and MySQL.
2. Create the "StudentDB" database.
3. Create the "students" table.
4. Insert sample username and password records.
5. Add the MySQL JDBC Connector to the project.
6. Update the database username and password in the source code if required.
7. Compile and run the "UseLogin.java" file.

Output

- If the entered username and password are correct, the application displays:
  - "You have successfully logged in"
- Otherwise, it displays:
  - "Wrong Username or Password"

Author
RinaMohan
