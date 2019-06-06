package com.javarush.task.task22.task2208;

import java.util.Collections;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        if (Collections.frequency(params.values(), null) == params.size()) return "";
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> parameters: params.entrySet())
        {
            if (parameters.getValue() != null) {
                builder.append(parameters.getKey() + " = \'" + parameters.getValue() + "\'" + " and ");
            }
        }
        return builder.substring(0, builder.lastIndexOf("and")).trim();
    }
}
