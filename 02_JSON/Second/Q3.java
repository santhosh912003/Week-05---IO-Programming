package org.rajesh.second;

import com.fasterxml.jackson.databind.*;
import java.io.File;

public class Q3 {
    public static void main(String[] args) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode users = mapper.readTree(new File("C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\second\\users.json"));

            for(JsonNode user : users){
                if(user.get("age").asInt() > 25){
                    System.out.println(user);
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
