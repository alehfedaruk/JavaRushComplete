package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new infiniteThread("Thread1"));
        threads.add(new interruptedThread("Thread2"));
        threads.add(new hoorayThread("Thread3"));
        threads.add(new messageThread("Thread4"));
        threads.add(new countingThread("Thread5"));
    }

    public static void main(String[] args) {
    }

    public static class infiniteThread extends Thread {
        public infiniteThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class interruptedThread extends Thread {
        public interruptedThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class hoorayThread extends Thread {
        public hoorayThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class messageThread extends Thread implements Message {
        public messageThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class countingThread extends Thread {
        private static String s;
        private static int x;
        private static int sum;

        public countingThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (true) {
                    s = reader.readLine();
                    if (s.equalsIgnoreCase("n")) {
                        break;
                    }
                    x = Integer.parseInt(s);
                    sum = sum + x;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}
