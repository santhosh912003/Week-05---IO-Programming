package org.rajesh.second;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
public class Q6 {
    public static void main(String[] args) {
        ObjectMapper jsonoMapper = new ObjectMapper();
        XmlMapper xml = new XmlMapper();

        try{
            JsonNode json = jsonoMapper.readTree(new File("C:\\Users\\Rajesh\\Desktop\\CapGemini-Trainning\\CapGemini-Trainning\\Week6\\untitled\\src\\main\\java\\org\\rajesh\\second\\users.json"));

            String xml_file = xml.writerWithDefaultPrettyPrinter().writeValueAsString(json);


            System.out.println(xml_file);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
