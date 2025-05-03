package org.rajesh.csv;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class Q15 {
    static class Encryptor {
        private static final String key = "1234567812345678"; // 16 chars
        private static final String algorithm = "AES";

        public static String encrypt(String value) throws Exception {

            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), algorithm);

            Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        }

        public static String decrypt(String value) throws Exception {

            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), algorithm);

            Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        }
    }

    public static void main(String[] args) throws Exception {
        // Encrypt and write

        PrintWriter writer = new PrintWriter("secure.csv");

        writer.println("Name,Email,Salary");

        writer.println("John," + Encryptor.encrypt("john@example.com") + "," + Encryptor.encrypt("50000"));

        writer.println("Jane," + Encryptor.encrypt("jane@example.com") + "," + Encryptor.encrypt("60000"));

        writer.close();

        // Decrypt and read
        BufferedReader br = new BufferedReader(new FileReader("secure.csv"));

        String line = br.readLine(); // skip header

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            System.out.println("Name: " + data[0] +

                    ", Email: " + Encryptor.decrypt(data[1]) +

                    ", Salary: " + Encryptor.decrypt(data[2]));

        }

        br.close();

    }

}
