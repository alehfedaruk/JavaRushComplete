package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader path = new BufferedReader(new InputStreamReader(System.in));
        String filePath = path.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String word;
        String [] splittedStr;

        while ((word = reader.readLine()) != null) {
            splittedStr = word.split("\\s");
            for (String test: splittedStr) {
                if (test.matches("\\b(\\d)*\\b")) {
                    if (map.containsKey(Integer.valueOf(test))) {
                        test = map.get(Integer.valueOf(test));
                    }
                }
                System.out.print(test + " ");
            }
        }

        path.close();
        reader.close();
    }
}
