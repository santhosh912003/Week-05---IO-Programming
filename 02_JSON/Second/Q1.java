package org.rajesh.second;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Q1 {

    public static void main(String[] args) {
        ObjectMapper map = new ObjectMapper();
        try{
            JsonNode root = map.readTree(new File("C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\data.json"));


            Iterator<String> keys = root.fieldNames();
            while(keys.hasNext()){
                String key = keys.next();
                System.out.println(key + ": "+ root.get(key));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
