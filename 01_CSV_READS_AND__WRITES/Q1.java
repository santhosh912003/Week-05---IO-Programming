package org.rajesh.csv;

import java.io.*;

public class Q1 {

    public static void main(String[] args) {
        String file = "students.csv";
        createCSVFile(file);
        readCSVFile(file);
    }

    private static void createCSVFile(String file) {
        String[] students = {
                "1,John Doe,20,85",
                "2,Jane Smith,22,90",
                "3,Sam Brown,19,78",
                "4,Lily Green,21,88",
                "5,James White,23,92"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("ID,Name,Age,Marks");
            bw.newLine();

            for (String student : students) {
                bw.write(student);
                bw.newLine();
            }

            System.out.println("students.csv created with sample data.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCSVFile(String file) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Marks: " + data[3]);
                System.out.println("-------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
