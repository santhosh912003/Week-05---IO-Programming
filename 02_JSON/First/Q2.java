package org.rajesh;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        ObjectMapper obj = new ObjectMapper();
        Carr c = new Carr("BMW","m8",2025);
        try{
            String json = obj.writeValueAsString(c);
            System.out.println(json);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}


class Carr{
    public String Brand;
    public String model ;
    public int year;


    public Carr(String Brand,String model,int year){
        this.Brand = Brand;
        this.model = model;
        this.year = year;

    }

    public Carr() {}

}