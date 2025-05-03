package org.rajesh.csv;

import java.io.*;
import java.util.*;

public class Q4 {
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
