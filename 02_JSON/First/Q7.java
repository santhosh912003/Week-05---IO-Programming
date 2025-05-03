package org.rajesh;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Q7 {
    public static void main(String[] args) {

        try{
            ObjectMapper map = new ObjectMapper();

            JsonNode root = map.readTree(new File("C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\people.json"));

            System.out.println("People with age > 25");

            for(JsonNode person : root){
                int age = person.get("age").asInt();
                if(age > 25){
                    System.out.println(person);
                }
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

}
