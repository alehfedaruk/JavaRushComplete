package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Pattern pattern = Pattern.compile("[a-zA-z]");
        Matcher matcher;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (fileInputStream.available() > 0) {
            sb.append((char) fileInputStream.read());
        }

        matcher = pattern.matcher(sb);
        while (matcher.find()) {
            count++;
        }

        fileInputStream.close();
        System.out.println(count);
    }
}
