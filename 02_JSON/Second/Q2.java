package org.rajesh.second;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Rajesh", 22),
                new User("Priya", 30)
        );


        try{
            ObjectMapper mapper  = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(users);
            System.out.println(jsonArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

class User {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}