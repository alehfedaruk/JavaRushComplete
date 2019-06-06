package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main (String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new FileReader(args[0]));
        Map<String, Double> namesMap = new TreeMap<> ();

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

        printMap(namesMap);

        reader.close ();
    }

    public static void printMap (Map<String, Double> mapToPrint) {
        for (Map.Entry<String, Double> testMap : mapToPrint.entrySet ()) {
            System.out.println (testMap.getKey () + " " + testMap.getValue ());
        }
    }
}
