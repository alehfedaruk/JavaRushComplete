package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        if (x <= 0 || y <= 0) {
            throw new Exception();
        }

        BigInteger firstValue = BigInteger.valueOf(x);
        BigInteger secondValue = BigInteger.valueOf(y);

        BigInteger gcd = firstValue.gcd(secondValue);

        System.out.println(gcd);

        reader.close();
    }
}
