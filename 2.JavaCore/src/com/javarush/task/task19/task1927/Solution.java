package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        PrintStream fake = new PrintStream(arrayOutputStream);

        System.setOut(fake);

        testString.printSomething();

        System.setOut(original);

        String n = arrayOutputStream.toString();

        String[] splittedString = n.split(System.lineSeparator());

        int count = 0;
        for (int i = 0; i < splittedString.length; i++) {
            System.out.println(splittedString[i]);
            count++;
            if (count % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
