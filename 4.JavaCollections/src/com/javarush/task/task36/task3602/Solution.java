package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class [] classes = Collections.class.getDeclaredClasses();
        Class result = Arrays.stream(classes).unordered().filter(aClass -> {
            boolean isStatic = Modifier.isStatic(aClass.getModifiers());
            boolean isPrivate = Modifier.isPrivate(aClass.getModifiers());
            boolean implementsInterfaceList = aClass.getName().contains("EmptyList");
            return isStatic && isPrivate && implementsInterfaceList;
        }).findAny().orElse(null);
        return result;
    }
}
