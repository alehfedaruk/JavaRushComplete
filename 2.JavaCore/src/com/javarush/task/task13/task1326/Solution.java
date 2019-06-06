package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

//        List <Integer> list = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//
//        FileInputStream fin = new FileInputStream(s);
//        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(fin));
//
//        int c;
//        try {
//            while (true) {
//                if (bufferedReader.read() != -1) {
//                    c = Integer.parseInt((bufferedReader.readLine()));
//                    if (c % 2 == 0) {
//                        list.add(c);
//                    }
//                } else
//                    break;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File wasn't found, check the path!");
//        }
//
//        Collections.sort(list);
//
//        for (Integer test : list) {
//            System.out.println(test);
//        }
//
//        fin.close();
//        reader.close();
//        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String fileName = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (fileReader.ready()){
                int i = Integer.parseInt(fileReader.readLine());
                if (i % 2 == 0)
                    list.add(i);
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        for (Integer i : list){
            System.out.println(i);
        }
    }
}


