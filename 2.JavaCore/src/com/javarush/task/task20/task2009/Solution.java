package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File objectfile = File.createTempFile("objectWithStaticField.bin",null);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectfile));
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(objectfile));

        ClassWithStatic first = new ClassWithStatic();
        ClassWithStatic.staticString = "22222";
        oos.writeObject(first);
        oos.close();

        String x = "2132";
        String y = "12312";
        System.out.println(x.equals(y));

        ClassWithStatic.staticString = "33333";

        ClassWithStatic second = (ClassWithStatic) ios.readObject();
        System.out.println(second.staticString);

        ios.close();
    }
}
