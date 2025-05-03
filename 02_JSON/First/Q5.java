package org.rajesh;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Q5 {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String Validjson = "{ \"name\": \"Rajesh\", \"age\": 25, \"email\": \"rajesh@example.com\" }";


        try{
            JsonNode root  = mapper.readTree(Validjson);

            System.out.println("Json syntax is valid one");
            System.out.println(root.toPrettyString());
        }
        catch (IOException e){
            System.out.println("❌ Invalid JSON syntax: " + e.getMessage());
        }

    }
}
