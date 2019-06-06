package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
    }

    public void recurse(int n) {
        if (n < 2) {
            return;
        }
        int increment = 2;

        while (increment <= n) {
            if (n % increment == 0) {
                System.out.print(increment + " ");
                if (n == increment) {
                    return;
                }
                break;
            }
            increment++;
        }
        recurse(n / increment);
    }
}

