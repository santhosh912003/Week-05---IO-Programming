package org.rajesh.csv;

import java.io.*;
import java.util.regex.*;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String email = data[1];
            String phone = data[2];

            boolean isEmailValid = emailPattern.matcher(email).matches();
            boolean isPhoneValid = phonePattern.matcher(phone).matches();

            if (!isEmailValid || !isPhoneValid) {
                System.out.println("Invalid row: " + line);
                if (!isEmailValid) System.out.println("Invalid Email: " + email);
                if (!isPhoneValid) System.out.println("Invalid Phone: " + phone);
            }
        }
        br.close();
    }
}
