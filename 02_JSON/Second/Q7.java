package org.rajesh.second;

import java.io.*;
import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\second\\data.csv";
        String line;
        String[] headers = null;
        List<Map<String, String>> jsonList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (lineNum == 0) {
                    headers = values;
                } else {
                    Map<String, String> obj = new LinkedHashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        obj.put(headers[i], values[i]);
                    }
                    jsonList.add(obj);
                }
                lineNum++;
            }
 // Print JSON
            System.out.println("[");
            for (int i = 0; i < jsonList.size(); i++) {
                Map<String, String> row = jsonList.get(i);
                System.out.print("  {");
                int j = 0;
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    System.out.print("\"" + entry.getKey() + "\": \"" + entry.getValue() + "\"");
                    if (++j < row.size()) System.out.print(", ");
                }
                System.out.print("}");
                if (i < jsonList.size() - 1) System.out.println(",");
                else System.out.println();
            }
            System.out.println("]");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
