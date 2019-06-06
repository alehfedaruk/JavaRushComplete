package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String oldFile = reader.readLine();
        String actualFile = reader.readLine();

        BufferedReader fileOldReader = new BufferedReader(new FileReader(oldFile));
        BufferedReader fileActualReader = new BufferedReader(new FileReader(actualFile));

        List<String> oldValues = new ArrayList<>();
        List<String> newValues = new ArrayList<>();

        while (fileOldReader.ready()) {
            String existingLine = fileOldReader.readLine();
            String updatedLine = fileActualReader.readLine();

            oldValues.add(existingLine);
            newValues.add(updatedLine);
        }

        if (oldValues.size() > newValues.size()) {
            for (int i = 0; i < oldValues.size(); i++) {
                if (oldValues.get(i).equals(newValues.get(i))) {
                    lines.add(new LineItem(Type.SAME,oldValues.get(i)));
                } else if (oldValues.get(i).equals(newValues.get(i+1))) {
                    
                }
            }
        }
     }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
