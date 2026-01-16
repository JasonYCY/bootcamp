package com.bootcamp.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
  private final Connection connection;

  public DatabaseManager(String url, String user, String password) throws SQLException {
    if (url == null || user == null || password == null) {
      throw new IllegalArgumentException();
    }
    this.connection = DriverManager.getConnection(url, user, password);
  }

  public boolean insert(Student student) {
    if (student == null) {
      return false;
    }
    try {
      String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getEmail());
      int rows = stmt.executeUpdate();
      System.out.println("Inserted: " + rows);
      return rows > 0 ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean deleteByName(String studentName) {
    if (studentName == null) {
      return false;
    }
    try {
      String sql = "DELETE FROM students WHERE name = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, studentName);
      int rows = stmt.executeUpdate();
      System.out.println("Deleted: " + rows);
      return rows > 0 ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean deleteById(int studentId) {
    try {
      String sql = "DELETE FROM students WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, studentId);
      int rows = stmt.executeUpdate();
      System.out.println("Deleted: " + rows);
      return rows > 0 ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean updateEmailByName(String newEmail, String studentName) {
    if (newEmail == null || studentName == null) {
      return false;
    }
    try {
      String sql = "UPDATE students SET email = ? WHERE name = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, newEmail);
      stmt.setString(2, studentName);
      int rows = stmt.executeUpdate();
      System.out.println("Updated: " + rows);
      return rows > 0 ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean updateEmailById(String newEmail, int studentId) {
    if (newEmail == null) {
      return false;
    }
    try {
      String sql = "UPDATE students SET email = ? WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, newEmail);
      stmt.setInt(2, studentId);
      int rows = stmt.executeUpdate();
      System.out.println("Updated: " + rows);
      return rows > 0 ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public List<Student> getStudents() {
    List<Student> studentList = new ArrayList<>();

    try (Connection conn = DBUtil.getConnection()) {
      String sql = "SELECT * FROM students";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        studentList.add(new Student(id, name, email));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return studentList;
  }





  // main method
  public static void main(String[] args) throws SQLException {
    String URL = "jdbc:mysql://localhost:3306/bootcamp_db";
    String USER = "root";
    String PASSWORD = "admin1234";
    DatabaseManager databaseManager = new DatabaseManager(URL, USER, PASSWORD);

    // System.out.println(databaseManager.updateEmailById("peter123@newEmail.com", -1));

    List<Student> students = databaseManager.getStudents();
    students.forEach(System.out::println);







  }
}
