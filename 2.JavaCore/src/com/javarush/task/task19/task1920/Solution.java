package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new FileReader(args[0]));

        Map<String, Double> namesMap = new TreeMap<>();

        String read;

        while ((read = reader.readLine ()) != null) {
            String[] arr = read.split ("\\s");
            if (!namesMap.containsKey (arr[0])) {
                namesMap.put (arr[0], Double.parseDouble (arr[1]));
            } else {
                Double addedValue = namesMap.get (arr[0]);
                namesMap.put (arr[0], Double.parseDouble (arr[1]) + addedValue);
            }
        }

        double maxValue = Collections.max(namesMap.values());
        namesMap.forEach((k,v) -> {
            if (v.equals(maxValue))
                System.out.println(k);
        });

        reader.close ();
    }
}
