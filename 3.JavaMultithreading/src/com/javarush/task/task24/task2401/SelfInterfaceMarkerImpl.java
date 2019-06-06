package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void testString (String test) {
        System.out.println(test);
    }

    public void idle () throws InterruptedException {
        Thread.sleep(100);
    }
}
