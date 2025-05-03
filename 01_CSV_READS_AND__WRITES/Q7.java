package org.rajesh.csv;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Q7 {
    public static void main(String[] args) {
        String input = "employees.csv";
        sortCsv(input);
    }

    private static void sortCsv(String input){
        List<String[]> recs =new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(input))){
            String header = br.readLine();

            recs.add(header.split(","));

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                recs.add(data);
            }

            List<String[]> sorted = recs.stream().skip(1).sorted((e1,e2) -> Double.compare(Double.parseDouble(e2[3]),Double.parseDouble(e1[3]))).collect(Collectors.toList());

            System.out.println("Top 5 highest-paid employees");
            for(int i=0;i<5 && i< sorted.size();i++){
                String[] emp = sorted.get(i);
                System.out.println("ID: " + emp[0] + ", Name: " + emp[1] + ", Department: " + emp[2] + ", Salary: " + emp[3]);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
