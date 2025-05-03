package org.rajesh.csv;

import java.io.*;
import java.util.*;

public class Q10 {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> map1 = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        PrintWriter writer = new PrintWriter("merged.csv");

        String line;
        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            map1.put(data[0], data);
        }

        while ((line = br2.readLine()) != null) {
            String[] data2 = line.split(",");
            String[] data1 = map1.get(data2[0]);
            if (data1 != null) {
                writer.println(String.join(",", data1[0], data1[1], data1[2], data2[1], data2[2]));
            }
        }

        br1.close();
        br2.close();
        writer.close();
    }
}
