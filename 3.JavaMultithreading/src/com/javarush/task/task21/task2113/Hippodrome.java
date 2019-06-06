package com.javarush.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(Arrays.asList(
                new Horse("MyHorse", 3, 0),
                new Horse("MyHorse1", 3, 0),
                new Horse("MyHorse2", 3, 0)));
        game.run();
        game.printWinner();
    }

    public void run () throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }


    public void print () {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }


    public void move () {
        horses.forEach(Horse::move);
    }

    public Horse getWinner () {
        double winnerDistance = Double.MIN_VALUE;
        Horse winnerHorse = null;
        for (Horse horse : horses) {
            if (horse.getDistance() >= winnerDistance) {
                winnerDistance = horse.getDistance();
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner () {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
