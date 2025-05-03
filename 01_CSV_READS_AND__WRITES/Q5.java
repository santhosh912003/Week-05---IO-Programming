package org.rajesh.csv;

import java.io.*;

public class Q5 {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String searchName = "Alice";  // Change this to search for a different employee
        searchEmployee(csvFile, searchName);
    }

    private static void searchEmployee(String csvFile, String searchName) {
        String line;
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    String department = data[2];
                    String salary = data[3];
                    System.out.println("Employee found!");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

