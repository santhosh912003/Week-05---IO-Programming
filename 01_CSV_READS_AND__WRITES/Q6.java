package org.rajesh.csv;
import java.io.*;
import java.util.*;


public class Q6 {

    public static void main(String[] args) {
        String input = "employees.csv";
        String updated = "updated_employees.csv";

        modify(input, updated);
    }

    private static void modify(String input, String output){
        String line;
        List<String[]> updated = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(input))){
            String header = br.readLine();
            updated.add(header.split(","));


            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                if("IT".equalsIgnoreCase(department)){
                    salary *= 1.10;
                    data[3] = String.format("%.2f",salary);
                }

                updated.add(data);
            }

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(output))){
                for(String[] record : updated){
                    writer.write(String.join(",",record)+"\n");
                }
            }

            System.out.println("updated employees records saved to "+ output);
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }

}
