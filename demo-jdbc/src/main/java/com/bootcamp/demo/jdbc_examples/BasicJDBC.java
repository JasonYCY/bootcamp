package com.bootcamp.demo.jdbc_examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBC {
  public static void main(String[] args) throws SQLException {
    // 1) Setup Connection
    String URL = "jdbc:mysql://localhost:3306/bootcamp_db";
    String USER = "root";
    String PASSWORD = "admin1234";
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

    // 2) Prepare Statement
    Statement statement = connection.createStatement();

    // 3) Write and execute SQL
    int updatedRows = statement.executeUpdate("UPDATE students SET name = 'Mary' WHERE id = 7;");
    System.out.println("Updated rows: " + updatedRows);

    ResultSet resultSet = statement.executeQuery("SELECT * FROM students;");

    // 4) Print result set
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      System.out.println(id + " " + name + " " + email);
    }

    // 5) Release resources
    resultSet.close();
    statement.close();
    connection.close();
  }
}
