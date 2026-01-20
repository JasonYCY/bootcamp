package com.bootcamp.demo.jdbc_examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoSQLInjection {
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



    // 3) Write SQL
    String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "';";
    System.out.println("\nSQL: " + sql + "\n");



    // 4) Create Statement
    Statement statement = connection.createStatement();



    // 5) Check username and password in database
    ResultSet resultSet = null;
    try {
      resultSet = statement.executeQuery(sql);

      if (resultSet.next()) {
        System.out.println("-= Login succeeded =-");
      } else {
        throw new IllegalArgumentException("Incorrect username or password!");
      }
    } catch (Exception e) {
      System.out.println("Login failed: " + e.getMessage());
    }



    // 6) Release resources
    resultSet.close();
    statement.close();
    connection.close();


  }
}
