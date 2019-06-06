package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //creating a reader from console stream
    public static BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    public static List<Integer> testList = new ArrayList<> ();
    public static String pathRead;
    public static String pathWrite;

    static {
        try {
            // setting up paths to the files
            pathRead = reader.readLine ();
            pathWrite = reader.readLine ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main (String[] args) throws IOException {
        FileInputStream fin = new FileInputStream (pathRead);
        FileOutputStream fout = new FileOutputStream (pathWrite);

        while (fin.available () > 0) {
            int data = fin.read ();
            testList.add (data);
        }

        for (int i = testList.size () - 1; i >= 0; i--) {
            fout.write (testList.get (i));
        }

        fin.close ();
        fout.close ();
        reader.close ();
    }
}
