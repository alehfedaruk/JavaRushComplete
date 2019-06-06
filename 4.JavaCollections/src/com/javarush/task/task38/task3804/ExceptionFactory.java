package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException (Enum en) {
        if (en == null) return new IllegalArgumentException();

        String message = en.name().substring(0,1) + en.name().substring(1).replaceAll("_", " ").toLowerCase();

        if (en instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            }
            if (en instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            }
            if (en instanceof UserExceptionMessage) {
                return new Error(message);
            }
        return new IllegalArgumentException();
    }
}
