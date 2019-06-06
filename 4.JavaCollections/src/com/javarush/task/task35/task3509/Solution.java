package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList <T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> testList = new ArrayList<>();
        for (Object element : elements) {
            testList.add((T) element);
        }
        return testList;
    }

    public static <T> HashSet <T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> testSet = new HashSet<>();
        for (Object element : elements) {
            testSet.add((T) element);
        }
        return testSet;
    }

    public static <K, V> HashMap <K, V> newHashMap(List <? extends K> keys, List <? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        else {
            HashMap<K,V> testMap = new HashMap<>();
            for (int i = 0; i < keys.size(); i++) {
                testMap.put(keys.get(i),values.get(i));
            }
            return testMap;
        }
    }
}
