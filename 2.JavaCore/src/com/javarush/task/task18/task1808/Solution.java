package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());

        int size = inputStream.available();
        if (size % 2 == 0) {
            for (int i = 0; i < size / 2; i++)
                outputStream.write(inputStream.read());
            for (int i = size / 2; i < size; i++)
                outputStream2.write(inputStream.read());
        } else {
            for (int i = 0; i < Math.ceil((double) size / 2); i++)
                outputStream.write(inputStream.read());
            for (int i = (int) Math.ceil(size / 2); i < size - 1; i++)
                outputStream2.write(inputStream.read());
        }

        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
