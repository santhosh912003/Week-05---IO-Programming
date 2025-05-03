package org.rajesh;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        ObjectMapper obj = new ObjectMapper();
        Student st = new Student("Rajesh",22);
        st.subjects.add("Maths");
        st.subjects.add("Python");
        st.subjects.add("Java Development");
        try{
            String json = obj.writeValueAsString(st);
            System.out.println(json);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}


class Student{
    public String name;
    public int age;
    public ArrayList<String> subjects;


    public Student(String name,int age){
        this.name = name;
        this.age = age;
        subjects = new ArrayList<>();

    }

    public Student() {}

}