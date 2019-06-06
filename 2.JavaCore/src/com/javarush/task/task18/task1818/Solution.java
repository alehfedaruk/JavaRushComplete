package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fos = new FileOutputStream(reader.readLine(),true);
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());

        while (fis.available() > 0) {
            int d = fis.read();
            fos.write(d);
        }

        while (fis2.available() > 0) {
            int d = fis2.read();
            fos.write(d);
        }

        fos.close();
        fis.close();
        fis2.close();
        reader.close();
    }
}
