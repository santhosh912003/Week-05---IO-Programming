package org.rajesh.csv;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        String csvFile = "employees.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("101,Rajesh,Engineering,75000\n");
            writer.append("102,Alice,Marketing,68000\n");
            writer.append("103,Bob,HR,62000\n");
            writer.append("104,Charlie,Finance,70000\n");
            writer.append("105,Eva,Sales,65000\n");

            System.out.println("Employee CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Q4 {
        public static void main(String[] args) {
            String csvFile = "students.csv";
            createCSVFile(csvFile);
            filterAndPrintCSV(csvFile);
        }

        private static void createCSVFile(String csvFile) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                writer.write("ID,Name,Age,Marks\n");
                writer.write("1,Rajesh,22,85\n");
                writer.write("2,Alice,21,90\n");
                writer.write("3,Bob,23,78\n");
                writer.write("4,Charlie,22,88\n");
                writer.write("5,Eva,21,92\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void filterAndPrintCSV(String csvFile) {
            String line;
            List<String[]> qualifyingStudents = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    int marks = Integer.parseInt(data[3]);

                    if (marks > 80) {
                        qualifyingStudents.add(data);
                    }
                }

                System.out.println("Students with marks greater than 80:");
                for (String[] student : qualifyingStudents) {
                    System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Age: " + student[2] + ", Marks: " + student[3]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
