package org.rajesh.csv;

import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    Student(int id, String name, int age) {
        this.id = id; this.name = name; this.age = age;
    }
    public String toString() {
        return id + ", " + name + ", " + age;
    }
}

public class Q9 {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            students.add(new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2])));
        }
        br.close();
        students.forEach(System.out::println);
    }
}

