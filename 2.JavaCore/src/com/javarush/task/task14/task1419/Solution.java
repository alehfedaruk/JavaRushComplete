package com.javarush.task.task14.task1419;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        initExceptions1();
        initExceptions2();
        initExceptions3();
        initExceptions4();
        initExceptions5();
        initExceptions6();
        initExceptions7();
        initExceptions8();
        initExceptions9();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions1() {
        try {
            Double d = new Double("qwe");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions2() {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("F:/ffff"));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions3() {
        int [] array = new int[0];
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println(array[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions4() {
        try {
            String s = null;
            System.out.println(s.charAt(0));
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions5() {
        try {
            String s = "hi";
            System.out.println(s.charAt(9));
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions6() {
        try {
            new URL("malformedurl");
        } catch (MalformedURLException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions7() {
        try {
            Object d = 12.55;
            Float e = (Float) d;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions8() {
        try {
            int[] a = new int[-5];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
    }

    private static void initExceptions9() {
        try {
            String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
            List<String> flowerList = Arrays.asList(flowers);
            flowerList.add("Celosia");
        } catch (UnsupportedOperationException e) {
            exceptions.add(e);
        }
    }
}


