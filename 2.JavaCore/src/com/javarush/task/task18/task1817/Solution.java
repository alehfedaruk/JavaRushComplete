package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        StringBuilder sb = new StringBuilder();
        int count;
        int count2 = 0;
        while (fileInputStream.available() > 0) {
            sb.append((char) fileInputStream.read());
        }

        count = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                count2++;
            }
        }

        double res = (double) count2 / count;

        fileInputStream.close();
        System.out.printf("%.2f", res * 100);
    }
}
