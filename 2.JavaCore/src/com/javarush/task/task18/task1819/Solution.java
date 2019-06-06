package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String second = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(first);
        FileInputStream fileInputStream1 = new FileInputStream(second);

        byte[] bytes = new byte[fileInputStream.available() + fileInputStream1.available()];


        while (fileInputStream.available() > 0) {
            fileInputStream.read(bytes, fileInputStream1.available(), fileInputStream.available());
        }
        while (fileInputStream1.available() > 0) {
            fileInputStream1.read(bytes, 0, fileInputStream1.available());
        }

        FileOutputStream fos = new FileOutputStream(first);
        fos.write(bytes,0,bytes.length);

        fileInputStream.close();
        fileInputStream1.close();
        fos.close();
        reader.close();
    }
}
