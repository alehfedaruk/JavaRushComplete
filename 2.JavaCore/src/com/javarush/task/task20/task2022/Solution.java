package com.javarush.task.task20.task2022;

import java.io.*;
import java.lang.reflect.Field;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        this.stream = new FileOutputStream(fileName);
        setFilename(stream);
    }

    public String setFilename (FileOutputStream stream) throws NoSuchFieldException, IllegalAccessException {
        Field field = FileOutputStream.class.getDeclaredField("path");
        field.setAccessible(true);
        return this.filename = (String) field.get(stream);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(filename,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
    }
}
