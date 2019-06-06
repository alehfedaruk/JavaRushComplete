package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        FileWriter fileWriter = new FileWriter(args[1]);

        String readString;
        String[] splittedStr;

        List<String> listToWrite = new ArrayList<>();

        while ((readString = reader.readLine()) != null) {
            splittedStr = readString.split(" ");
            for (String test : splittedStr) {
                if (test.length() > 6) {
                    listToWrite.add(test);
                }
            }
        }

        for (String test : listToWrite) {
            if (!test.equals(listToWrite.get(listToWrite.size() - 1))) {
                fileWriter.write(test + ",");
            } else {
                fileWriter.write(test);
            }
        }

        reader.close();
        fileWriter.close();
    }
}
