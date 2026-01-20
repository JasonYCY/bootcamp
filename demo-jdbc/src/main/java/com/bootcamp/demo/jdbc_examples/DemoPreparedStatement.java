package com.bootcamp.demo.jdbc_examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoPreparedStatement {
  public static void main(String[] args) throws SQLException {
    // 1) Create Connection
    String URL = "jdbc:mysql://localhost:3306/bootcamp_db";
    String USER = "root";
    String PASSWORD = "admin1234";
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);



    // 2) Get user input
    System.out.println("-= User Login =-");
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please enter your username: ");
    String username = scanner.nextLine();

    System.out.print("Please enter your password: "); // SQL Injection: ' OR 1 = 1 -- 
    String password = scanner.nextLine();
    scanner.close();



    // 3) Write SQL with placeholders (?) instead of concatenation
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    System.out.println("\nSQL Template: " + sql + "\n");



    // 4) Create PreparedStatement instead of Statement
    PreparedStatement preparedStatement = connection.prepareStatement(sql);



    // 5) Set parameters
    preparedStatement.setString(1, username);  // First ? = username
    preparedStatement.setString(2, password);  // Second ? = password
    System.out.println(preparedStatement);



    // 6) Execute query
    ResultSet resultSet = null;
    try {
      resultSet = preparedStatement.executeQuery();  // No SQL parameter here!

      if (resultSet.next()) {
        System.out.println("-= Login succeeded =-");
      } else {
        throw new IllegalArgumentException("Incorrect username or password!");
      }
    } catch (Exception e) {
      System.out.println("Login failed: " + e.getMessage());
    }



    // 7) Release resources
    resultSet.close();
    preparedStatement.close();
    connection.close();



    // 8) Actual SQL

    // -- 1. First prepare the statement
    // PREPARE stmt1 FROM 'SELECT * FROM users WHERE username = ? AND password = ?';

    // -- 2. Set user variables
    // SET @username = 'admin';
    // SET @password = 'admin123';

    // -- 3. Execute using user variables (starts with @)
    // EXECUTE stmt1 USING @username, @password;

    // -- 4. Clean up
    // DEALLOCATE PREPARE stmt1;


  }
}
