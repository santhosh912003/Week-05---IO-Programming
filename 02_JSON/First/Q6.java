package org.rajesh;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        try{
            ObjectMapper obj = new ObjectMapper();
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("BMW", "Black", 2022));
            cars.add(new Car("Tesla", "White", 2023));
            cars.add(new Car("Toyota", "Blue", 2020));

            String JsonArray = obj.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
            System.out.println(JsonArray);


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


class Car {
    public String brand;
    public String color;
    public int year;

    public Car() {}  // Default constructor for Jackson

    public Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }
}