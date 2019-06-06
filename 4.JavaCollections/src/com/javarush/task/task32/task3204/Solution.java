package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        String shuffle = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        char lower = lowerCase.charAt((int) (Math.random() * lowerCase.length()));
        char upper = upperCase.charAt((int) (Math.random() * upperCase.length()));
        char number = numbers.charAt((int) (Math.random() * numbers.length()));

        StringBuilder builder = new StringBuilder();

        while (builder.length() < 5) {
            builder.append(shuffle.charAt((int) (Math.random() * shuffle.length())));
        }

        builder.append(lower);
        builder.append(upper);
        builder.append(number);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(builder.toString().getBytes());

        return byteArrayOutputStream;
    }
}