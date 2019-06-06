package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filePath = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            List<String> myList = new ArrayList<>(asList(line.split(" ")));
            myList.retainAll(words);
            if (myList.size() == 2) {
                System.out.println(line);
            }
        }

        fileReader.close();
        reader.close();
    }
}
