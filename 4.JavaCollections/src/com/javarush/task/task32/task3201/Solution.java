package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        int position = Integer.parseInt(args[1]);
        String text = args[2];

        if (raf.length() < position) {
            raf.seek(raf.length());
            raf.write(text.getBytes());
        } else {
            raf.seek(position);
            raf.write(text.getBytes());
        }

        raf.close();
    }
}
