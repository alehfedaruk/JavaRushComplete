package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        FileWriter fileWriter = new FileWriter(args[1]);

        List<String> wordsList = new ArrayList<>();

        String textLine;
        String[] splittedString;

        while ((textLine = reader.readLine()) != null) {
            splittedString = textLine.split("\\s");
            wordsList.addAll(Arrays.asList(splittedString));
        }

        wordsList.forEach(word -> {
            try {
                if (word.replaceAll("\\D", "").length() > 0) fileWriter.write(word+" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        fileWriter.close();
        reader.close();
    }
}
