package org.rajesh.csv;

import java.io.*;
import java.sql.*;

public class Q13 {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("employees.csv");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, dept, salary FROM employees")) {

            writer.println("Employee ID,Name,Department,Salary");
            while (rs.next()) {
                writer.printf("%d,%s,%s,%.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("dept"),
                        rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

