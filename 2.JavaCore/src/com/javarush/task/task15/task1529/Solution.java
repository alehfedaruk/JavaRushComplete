package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static
    {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = null;
        try {
            int numberOfPassengers;
            reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            if (input.equalsIgnoreCase("helicopter")) {
                result = new Helicopter();
            } else if (input.equalsIgnoreCase("plane")) {
                numberOfPassengers = Integer.parseInt(reader.readLine());
                result = new Plane(numberOfPassengers);
            } else {
                System.out.println("No objects of type " + Plane.class.getSimpleName() +
                        " or " + Helicopter.class.getSimpleName() + " found.");
            }
        } catch (IOException e) {
            System.out.println("Exception caught");
        } finally {
            try {
                if (reader != null)
                reader.close();
            } catch (IOException e) {
                System.out.println("Another exception caught");
            }
        }
    }
}
