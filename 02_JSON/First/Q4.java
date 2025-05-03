package org.rajesh;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;


public class Q4 {
    public static void main(String[] args) {

        ObjectMapper obj = new ObjectMapper();

        String json1 = "{ \"name\": \"Rajesh\", \"age\": 22 }";

        String json2 = "{ \"email\": \"rajesh@example.com\", \"address\": \"123 Main St\" }";

        try{

            JsonNode node1 = obj.readTree(json1);
            JsonNode node2 = obj.readTree(json2);


            JsonNode merged = MergedNode(node1,node2);

            System.out.println(merged.toPrettyString());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static JsonNode MergedNode(JsonNode node1, JsonNode node2){
        JsonNode merge = node1.deepCopy();


        node2.fields().forEachRemaining(field -> {
            ((ObjectNode) merge) .set(field.getKey(),field.getValue());
        });

        return merge;
    }

}
