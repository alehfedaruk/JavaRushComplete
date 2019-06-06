package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put(24.5,"Weight");
        labels.put(14.3,"Height");
        labels.put(18.8,"BodyMassIndex");
        labels.put(10.0,"JustDick");
        labels.put(5.75,"Coolness");
    }
}
