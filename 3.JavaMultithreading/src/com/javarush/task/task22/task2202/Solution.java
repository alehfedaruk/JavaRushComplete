package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        if (string.codePoints().filter(value -> value == ' ').count() < 4) throw new TooShortStringException();
        int requiredIndex = 4;
        String [] strings = string.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < requiredIndex + 1; i++) {
            builder.append(strings[i] + " ");
        }
        return builder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
