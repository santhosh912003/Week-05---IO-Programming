package org.rajesh.csv;

import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Q14 {
    public static void main(String[] args) throws IOException {
        // JSON to CSV
        String jsonStr = new String(Files.readAllBytes(Paths.get("students.json")));
        JSONArray arr = new JSONArray(jsonStr);
        PrintWriter writer = new PrintWriter("students.csv");
        writer.println("ID,Name,Age");

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            writer.printf("%d,%s,%d%n", obj.getInt("id"), obj.getString("name"), obj.getInt("age"));
        }
        writer.close();

        // CSV to JSON
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        JSONArray resultArr = new JSONArray();
        String line = br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            JSONObject obj = new JSONObject();
            obj.put("id", Integer.parseInt(data[0]));
            obj.put("name", data[1]);
            obj.put("age", Integer.parseInt(data[2]));
            resultArr.put(obj);
        }
        br.close();
        Files.write(Paths.get("students_back.json"), resultArr.toString(2).getBytes());
    }
}
