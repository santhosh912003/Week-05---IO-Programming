package org.rajesh;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class Q3 {
    public static void main(String[] args) {

        ObjectMapper obj = new ObjectMapper();

        try{
            System.out.println(System.getProperty("user.dir"));

            JsonNode root = obj.readTree(new File("C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\data.json"));


            String name = root.path("name").asText();
            String email = root.path("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);


        }

        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
