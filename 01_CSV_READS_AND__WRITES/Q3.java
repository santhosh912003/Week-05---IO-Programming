package org.rajesh.csv;


import java.io.*;


public class Q3 {
    public static void main(String[] args) {
        String csv = "employees.csv";
        String line;
        int cnt = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(csv))){
            br.readLine();

            while((line = br.readLine()) != null){
                cnt++;
            }

            System.out.println("Total number of employee records: "+ cnt);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
