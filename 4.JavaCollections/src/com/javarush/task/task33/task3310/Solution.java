package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static Set<Long> getIds (Shortener shortener, Set<String> strings) {
        return strings.stream().map(shortener::getId).collect(Collectors.toSet());
    }

    public static Set<String> getStrings (Shortener shortener, Set<Long> keys) {
        return keys.stream().map(shortener::getString).collect(Collectors.toSet());
    }

    public static void testStrategy (StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date beforeGetIds = new Date();
        Set<Long> ids = getIds(shortener, testSet);
        Date afterGetIds = new Date();
        Helper.printMessage(String.valueOf(afterGetIds.getTime() - beforeGetIds.getTime()));

        Date beforeGetStrings = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date afterGetStrings = new Date();
        Helper.printMessage(String.valueOf(afterGetStrings.getTime() - beforeGetStrings.getTime()));
        if (testSet.size() == strings.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        HashMapStorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy, 10000);
    }
}
