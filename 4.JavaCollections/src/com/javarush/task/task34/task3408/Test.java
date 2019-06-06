package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("com.javarush.task.task34.task3408.Cache");
        System.out.println(clazz.getName());
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
        Cache cache = (Cache) clazz.getConstructor().newInstance();
        System.out.println(cache.size());
        Class [] classes = Class.forName("com.javarush.task.task34.task3408.Solution").getDeclaredClasses();

        Solution.SomeValue value;
        for (Class aClass : classes) {
            System.out.println(aClass.getName());
            if (aClass.getName().endsWith("SomeValue")) {
                Constructor [] constructors = aClass.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    if (constructor.getParameterCount() != 0) {
                        value = (Solution.SomeValue) aClass.getConstructor(Solution.SomeKey.class).newInstance(new Solution.SomeKey());
                        System.out.println(value.getClass().getDeclaredField("myKey"));
                    }
                }
            }
        }
    }
}
