package org.rajesh.csv;

import java.io.*;
import java.util.*;

public class Q12 {
    public static void main(String[] args) throws IOException {
        Set<String> ids = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];
            if (!ids.add(id)) {
                System.out.println("🔁 Duplicate Found: " + line);
            }
        }
        br.close();
    }
}
