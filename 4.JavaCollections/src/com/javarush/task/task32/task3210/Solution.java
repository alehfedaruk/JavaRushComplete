package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        int position = Integer.parseInt(args[1]);
        String text = args[2];
        int textLength = text.length();
        byte [] array = new byte[textLength];

        raf.seek(position);
        raf.read(array, 0, textLength);

        String readText = new String (array);
        if (readText.equals(text)) {
            raf.seek(raf.length());
            raf.write("true".getBytes());
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }

        raf.close();
    }
}
